package com.rtowebapi.controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rtowebapi.common.DateConvertor;
import com.rtowebapi.model.GetWork;
import com.rtowebapi.model.TaskDesc;
import com.rtowebapi.model.UpdateStatus;
import com.rtowebapi.model.Work;
import com.rtowebapi.model.WorkDetail;
import com.rtowebapi.repo.GetWorkRepo;
import com.rtowebapi.repo.TaskDescRepo;
import com.rtowebapi.repo.UpdateStatusRepo;
import com.rtowebapi.repo.WorkDetailRepo;
import com.rtowebapi.repo.WorkRepo;

@RestController
public class TxApiController {

	@Autowired
	WorkDetailRepo workDetailRepo;

	@Autowired
	WorkRepo workRepo;

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

	@RequestMapping(value = { "/getWorkHeaderByStatus" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWork> getWorkHeaderByStatus(@RequestParam("status") int status) {

		List<GetWork> workHeader = new ArrayList<>();

		try {

			workHeader = getWorkRepo.getWorkByStatus(status);
			for (int i = 0; i < workHeader.size(); i++) {
				workHeader.get(i).setDate1(DateConvertor.convertToDMY(workHeader.get(i).getDate1()));

				workHeader.get(i).setDate2(DateConvertor.convertToDMY(workHeader.get(i).getDate2()));
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

		System.out.println("updateList" + updateList.toString());
		int res;

		try {
			for (int i = 0; i < updateList.size(); i++) {
				System.out.println("size" + updateList.size());

				UpdateStatus u = updateList.get(i);

				res = updateStatusRepo.updateWorkHeaderStatusAndCost(u.getStatus(), u.getWorkId(), u.getWorkCost());

				if (res > 0) {

					errorMessage.setError(false);
					errorMessage.setMessage("success Update Order Header");

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

			workHeader.setDate2(DateConvertor.convertToDMY(workHeader.getDate2()));

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

}
