package com.rtowebapi.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rtowebapi.common.DateConvertor;
import com.rtowebapi.common.Firebase;
import com.rtowebapi.model.Cust;
import com.rtowebapi.model.GetCustWork;
import com.rtowebapi.model.GetWork;
import com.rtowebapi.model.TaskDesc;
import com.rtowebapi.model.UpdateStatus;
import com.rtowebapi.model.User;
import com.rtowebapi.model.Work;
import com.rtowebapi.model.WorkDetail;
import com.rtowebapi.model.WorkType;
import com.rtowebapi.repo.CustRepo;
import com.rtowebapi.repo.GetCustWorkRepo;
import com.rtowebapi.repo.GetWorkRepo;
import com.rtowebapi.repo.TaskDescRepo;
import com.rtowebapi.repo.UpdateStatusRepo;
import com.rtowebapi.repo.UserRepo;
import com.rtowebapi.repo.WorkDetailRepo;
import com.rtowebapi.repo.WorkRepo;
import com.rtowebapi.repo.WorkTypeRepo;

@RestController
public class TxApiController {

	@Autowired
	WorkDetailRepo workDetailRepo;

	@Autowired
	UserRepo userRepo;

	@Autowired
	WorkTypeRepo workTypeRepo;

	@Autowired
	WorkRepo workRepo;

	@Autowired
	CustRepo custRepo;

	@Autowired
	GetWorkRepo getWorkRepo;

	@Autowired
	UpdateStatusRepo updateStatusRepo;

	@Autowired
	TaskDescRepo taskDescRepo;

	@RequestMapping(value = { "/getTaskByInnerTaskId" }, method = RequestMethod.POST)
	public @ResponseBody TaskDesc getTaskByInnerTaskId(@RequestParam("innerTaskId") int innerTaskId) {

		TaskDesc right = new TaskDesc();

		try {
			right = taskDescRepo.findByInnerTaskId(innerTaskId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return right;

	}

	@RequestMapping(value = { "/getAllTaskList" }, method = RequestMethod.GET)
	public @ResponseBody List<TaskDesc> getAllTaskList() {

		List<TaskDesc> taskList = new ArrayList<TaskDesc>();

		try {

			taskList = taskDescRepo.findAll();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return taskList;

	}

	@RequestMapping(value = { "/saveOrderHeaderDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info saveOrderHeaderDetail(@RequestBody Work work) {

		Info errorMessage = new Info();

		Work workRes = new Work();

		try {

			workRes = workRepo.saveAndFlush(work);

			for (int i = 0; i < work.getWorkDetailList().size(); i++) {
				work.getWorkDetailList().get(i).setWorkId(workRes.getWorkId());

				List<WorkDetail> workDetailList = workDetailRepo.saveAll(work.getWorkDetailList());
				System.out.println("workDetailList" + workDetailList.toString());
				workRes.setWorkDetailList(workDetailList);
			}
			errorMessage.setError(false);
			errorMessage.setMessage("successfully Saved ");
		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMessage("failed to Save ");

		}
		return errorMessage;

	}

	@RequestMapping(value = { "/getWorkHeaderAndDetail" }, method = RequestMethod.POST)
	public @ResponseBody Work getWorkHeaderAndDetail(@RequestParam("workId") int workId) {

		Work workHeader = new Work();

		try {

			workHeader = workRepo.findByWorkId(workId);
			System.out.println("workId" + workId);
			System.out.println("Work Header" + workHeader.toString());
			List<WorkDetail> workDetailList = workDetailRepo.findByWorkId(workId);
			workHeader.setWorkDetailList(workDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return workHeader;

	}

	@RequestMapping(value = { "/getWorkHeaderAndDetailByType" }, method = RequestMethod.POST)
	public @ResponseBody Work getWorkHeaderAndDetailByType(@RequestParam("status") int status) {

		Work workHeader = new Work();

		try {

			workHeader = workRepo.findByStatus(status);

			System.out.println("Work Header" + workHeader.toString());
			List<WorkDetail> workDetailList = workDetailRepo.findByWorkId(workHeader.getWorkId());
			workHeader.setWorkDetailList(workDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return workHeader;

	}
	
	
	
	
	@RequestMapping(value = { "/getWorkHeaderByIsUsed" }, method = RequestMethod.GET)
	public @ResponseBody List<GetWork> getWorkHeaderByIsUsed() {

		List<GetWork> workHeader = new ArrayList<>();

		try {

			workHeader = getWorkRepo.findByIsUsed(1);
			for (int i = 0; i < workHeader.size(); i++) {
				workHeader.get(i).setDate1(DateConvertor.convertToDMY(workHeader.get(i).getDate1()));
				//System.out.println(workHeader.get(35));
			}


		} catch (Exception e) {

			System.err.println("Exce in getCustWorkHeader " + e.getMessage());

			e.printStackTrace();

		}

		return workHeader;

	}

	
	@RequestMapping(value = { "/getWorkHeaderByStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWork> getWorkHeaderByStatus(@RequestParam("status") int status) {

		List<GetWork> workHeader = new ArrayList<>();

		try {

			workHeader = getWorkRepo.getWorkByStatus(status);
			for (int i = 0; i < workHeader.size(); i++) {
				workHeader.get(i).setDate1(DateConvertor.convertToDMY(workHeader.get(i).getDate1()));
				//System.out.println(workHeader.get(35));
			}

		
		} catch (Exception e) {

			e.printStackTrace();

		}
		return workHeader;

	}
	

	
	@RequestMapping(value = { "/getWorkHeaderList" }, method = RequestMethod.GET)
	public @ResponseBody List<GetWork> getWorkHeaderListDetail() {

		List<GetWork> workHeader = new ArrayList<>();

		try {

			workHeader = getWorkRepo.findByIsUsed(1);
			for (int i = 0; i < workHeader.size(); i++) {
				workHeader.get(i).setDate1(DateConvertor.convertToDMY(workHeader.get(i).getDate1()));
				//System.out.println(workHeader.get(35));
			}

		
		} catch (Exception e) {

			e.printStackTrace();

		}
		return workHeader;

	}
//Sachin 2 Nov for RTO android Anmol
	@RequestMapping(value = { "/getCustWorkHeader" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWork> getCustWorkHeader(@RequestParam("custId") int custId) {

		List<GetWork> workHeader = new ArrayList<>();

		try {

			workHeader = getWorkRepo.getWorkByCustId(custId);
			for (int i = 0; i < workHeader.size(); i++) {
				workHeader.get(i).setDate1(DateConvertor.convertToDMY(workHeader.get(i).getDate1()));

			}

		} catch (Exception e) {

			System.err.println("Exce in getCustWorkHeader " + e.getMessage());

			e.printStackTrace();

		}

		return workHeader;

	}

	// Sachin 12 Nov for RTO android Anmol

	@Autowired
	GetCustWorkRepo getCustWorkRepo;

	@RequestMapping(value = { "/getCustWorkByUserId" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCustWork> getCustWorkByCustId(@RequestParam("status") int status,
			@RequestParam("userId") int userId) {

		List<GetCustWork> workHeader = new ArrayList<>();

		try {

			workHeader = getCustWorkRepo.getCustWorkByUserIdAndStatus(userId, status);
			for (int i = 0; i < workHeader.size(); i++) {
				workHeader.get(i).setDate1(DateConvertor.convertToDMY(workHeader.get(i).getDate1()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return workHeader;

	}

	@RequestMapping(value = { "/getCustWorkByUserIdAndDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCustWork> getCustWorkByUserIdAndDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("userId") int userId) {

		List<GetCustWork> workHeader = new ArrayList<>();

		try {

			workHeader = getCustWorkRepo.getCustWorkByUserIdAndDate(userId, fromDate, toDate);
			for (int i = 0; i < workHeader.size(); i++) {
				workHeader.get(i).setDate1(DateConvertor.convertToDMY(workHeader.get(i).getDate1()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return workHeader;

	}

	@RequestMapping(value = { "/deleteWork" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteWork(@RequestParam("workId") int workId) {

		Info info = new Info();

		try {
			int delete = workRepo.deleteWork(workId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/deleteWorkDetail" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteWorkDetail(@RequestParam("workDetailId") int workDetailId) {

		Info info = new Info();

		try {
			int delete = workDetailRepo.deleteWorkDetail(workDetailId);

			if (delete == 1) {
				info.setError(false);
				info.setMessage("successfully Deleted");
			} else {
				info.setError(true);
				info.setMessage(" Deleted to Delete");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMessage(" Deleted to Delete");

		}
		return info;

	}

	@RequestMapping(value = { "/updateWorkHeaderStatusAndCost" }, method = RequestMethod.POST)
	public @ResponseBody Info updateWorkHeaderStatusAndCost(@RequestBody List<UpdateStatus> updateList) {

		Info errorMessage = new Info();
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf1.format(now.getTime());
		String dateTime = sdf.format(now.getTime());
		int res;
		WorkDetail workRes = new WorkDetail();

		System.out.println("updateList" + updateList.toString());

		try {
			for (int i = 0; i < updateList.size(); i++) {
				System.out.println("size" + updateList.size());

				UpdateStatus u = updateList.get(i);

				res = updateStatusRepo.updateWorkHeaderStatusAndCost(u.getStatus(), u.getWorkId(), u.getWorkCost());

				if (res > 0) {
					Work work = new Work();
					work = workRepo.findByWorkId(updateList.get(i).getWorkId());

					Cust cust = new Cust();
					cust = custRepo.findByCustId(work.getCustId());

					WorkType wType = new WorkType();

					wType = workTypeRepo.findByWorkTypeId(work.getWorkTypeTd());

					Firebase.sendPushNotification(cust.getExStr1(), "Easy RTO",
							wType.getWorkTypeName() + "\\n Status : Uploads Document : ", 2);

					errorMessage.setError(false);
					errorMessage.setMessage("success Update Order Header");

					WorkDetail w = new WorkDetail();
					w.setDate(date);
					w.setExInt1(u.getExInt1());
					w.setExInt2(u.getExInt2());
					w.setIsUsed(1);
					w.setInnerTaskId(u.getStatus());
					w.setDateTime(dateTime);
					w.setWorkId(u.getWorkId());
					w.setWorkDesc("Update Payment");

					workRes = workDetailRepo.saveAndFlush(w);

				}

			}

		} catch (Exception e) {

			System.err.println("exc in update order " + e.getMessage());
			e.printStackTrace();
			errorMessage.setError(true);

		}

		return errorMessage;
	}

	@RequestMapping(value = { "/updateWorkStatus" }, method = RequestMethod.POST)
	public @ResponseBody Info updateWorkStatus(@RequestParam("workIdList") List<Integer> workIdList,
			@RequestParam("status") int status) {

		Info errorMessage = new Info();

		int res;

		try {

			res = workRepo.updateWorkStatus(status, workIdList);

			for (int i = 0; i < workIdList.size(); i++) {

				if (res > 0) {

					errorMessage.setError(false);
					errorMessage.setMessage("success Update Status");

					Work work = new Work();
					work = workRepo.findByWorkId(workIdList.get(i));

					Cust cust = new Cust();
					cust = custRepo.findByCustId(work.getCustId());

					WorkType wType = new WorkType();

					wType = workTypeRepo.findByWorkTypeId(work.getWorkTypeTd());

					if (work.getStatus() == 4) {

						Firebase.sendPushNotification(cust.getExStr1(), "Easy RTO",
								wType.getWorkTypeName() + "\nStatus : User Allocated ", 4);
					} else if (work.getStatus() == 5) {

						Firebase.sendPushNotification(cust.getExStr1(), "Easy RTO",
								wType.getWorkTypeName() + "\nStatus : Document In Office ", 4);
					}

					else if (work.getStatus() == 6) {

						Firebase.sendPushNotification(cust.getExStr1(), "Easy RTO",
								wType.getWorkTypeName() + "\nStatus :Document Submit to RTO ", 4);
					} else if (work.getStatus() == 7) {

						Firebase.sendPushNotification(cust.getExStr1(), "Easy RTO",
								wType.getWorkTypeName() + "\nStatus : Handover Document upto Customer ", 4);
					}

				}
			}

		} catch (Exception e) {

			System.err.println("exc in update order " + e.getMessage());
			e.printStackTrace();
			errorMessage.setError(false);

		}

		return errorMessage;
	}

	@RequestMapping(value = { "/updateWorkStatusAndUserId" }, method = RequestMethod.POST)
	public @ResponseBody Info updateWorkStatusAndUserId(@RequestParam("workIdList") List<Integer> workIdList,
			@RequestParam("status") int status, @RequestParam("userId") String userId) {

		Info errorMessage = new Info();
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf1.format(now.getTime());
		String dateTime = sdf.format(now.getTime());
		int res;
		WorkDetail workRes = new WorkDetail();
		try {

			res = workRepo.updateWorkUsrId(status, workIdList, userId);

			for (int i = 0; i < workIdList.size(); i++) {

				if (res > 0) {

					Work work = new Work();
					work = workRepo.findByWorkId(workIdList.get(i));

					Cust cust = new Cust();
					cust = custRepo.findByCustId(work.getCustId());

					WorkType wType = new WorkType();

					wType = workTypeRepo.findByWorkTypeId(work.getWorkTypeTd());

					Firebase.sendPushNotification(cust.getExStr1(), "Easy RTO",
							wType.getWorkTypeName() + "\nStatus : Update Payment Done ", 3);

					User user = new User();
					user = userRepo.findByUserId(Integer.parseInt(userId));

					Firebase.sendPushNotification(user.getExStr1(), "Easy RTO", wType.getWorkTypeName()
							+ "Customer Name : " + cust.getCustName() + " Address : " + cust.getAddPincode(), 3);

					errorMessage.setError(false);
					errorMessage.setMessage("success Update Status");

					WorkDetail w = new WorkDetail();
					w.setDate(date);

					w.setIsUsed(1);
					w.setInnerTaskId(status);
					w.setDateTime(dateTime);

					w.setWorkDesc("User Allocation");

					workRes = workDetailRepo.saveAndFlush(w);

				}
			}

		} catch (Exception e) {

			System.err.println("exc in update order " + e.getMessage());
			e.printStackTrace();
			errorMessage.setError(true);

		}

		return errorMessage;
	}

	@RequestMapping(value = { "/getWorkHeaderByWorkId" }, method = RequestMethod.POST)
	public @ResponseBody GetWork getWorkHeaderByWorkId(@RequestParam("workId") int workId) {

		GetWork workHeader = new GetWork();

		try {

			workHeader = getWorkRepo.getWorkByWorkId(workId);

			workHeader.setDate1(DateConvertor.convertToDMY(workHeader.getDate1()));

			List<WorkDetail> workDetailList = workDetailRepo.findByWorkId(workId);
			for (int i = 0; i < workDetailList.size(); i++) {
				workDetailList.get(i).setDate(DateConvertor.convertToDMY(workDetailList.get(i).getDate()));
			}
			workHeader.setWorkDetailList(workDetailList);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return workHeader;

	}

	@RequestMapping(value = { "/updateWorkPayment" }, method = RequestMethod.POST)
	public @ResponseBody Info updateWorkPayment(@RequestBody List<UpdateStatus> updateList) {

		Info errorMessage = new Info();
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf1.format(now.getTime());
		String dateTime = sdf.format(now.getTime());

		System.out.println("updateList" + updateList.toString());
		int res;
		WorkDetail workRes = new WorkDetail();

		try {
			for (int i = 0; i < updateList.size(); i++) {
				System.out.println("size" + updateList.size());

				UpdateStatus u = updateList.get(i);

				res = updateStatusRepo.updateWorkPayment(u.getStatus(), u.getWorkId(), u.getExInt1(), u.getExInt2());

				if (res > 0) {

					System.out.println("Id" + updateList.get(i).getWorkId());

					Work work = new Work();
					work = workRepo.findByWorkId(updateList.get(i).getWorkId());

					Cust cust = new Cust();
					cust = custRepo.findByCustId(work.getCustId());

					System.out.println("work" + work.toString());

					WorkType wType = new WorkType();

					wType = workTypeRepo.findByWorkTypeId(work.getWorkTypeTd());

					System.out.println("wType" + wType.toString());

					Firebase.sendPushNotification(cust.getExStr1(), "Easy RTO",
							wType.getWorkTypeName() + "\n Status : Update Work Cost ", 2);

					errorMessage.setError(false);
					errorMessage.setMessage("success Update Order Header");

					WorkDetail w = new WorkDetail();
					w.setDate(date);
					w.setExInt1(u.getExInt1());
					w.setExInt2(u.getExInt2());
					w.setIsUsed(1);
					w.setInnerTaskId(u.getStatus());
					w.setDateTime(dateTime);
					w.setWorkId(u.getWorkId());
					w.setWorkDesc("User Allocation");

					workRes = workDetailRepo.saveAndFlush(w);

					System.out.println("workRes" + workRes.toString());

				}

			}

		} catch (Exception e) {

			System.err.println("exc in update order " + e.getMessage());
			e.printStackTrace();
			errorMessage.setError(true);

		}

		return errorMessage;
	}

}
