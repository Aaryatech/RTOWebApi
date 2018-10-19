package com.rtowebapi.controller;

import java.text.DateFormat;
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
import com.rtowebapi.model.Cust;
import com.rtowebapi.model.Right;
import com.rtowebapi.model.User;
import com.rtowebapi.model.WorkType;
import com.rtowebapi.repo.CustRepo;
import com.rtowebapi.repo.RightRepo;
import com.rtowebapi.repo.UserRepo;
import com.rtowebapi.repo.WorkTypeRepo;

@RestController
public class MasterApiController {

	@Autowired
	UserRepo userRepo;

	@Autowired
	RightRepo rightRepo;

	@Autowired
	WorkTypeRepo workTypeRepo;

	@Autowired
	CustRepo custRepo;

	// ----------------------------------------Customer----------------------------------------------------

	@RequestMapping(value = { "/saveCust" }, method = RequestMethod.POST)
	public @ResponseBody Cust saveCust(@RequestBody Cust cust) {

		Cust res = new Cust();

		try {

			res = custRepo.saveAndFlush(cust);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getCustByCustId" }, method = RequestMethod.POST)
	public @ResponseBody Cust getCustByCustId(@RequestParam("custId") int custId) {

		Cust cust = new Cust();

		try {
			cust = custRepo.findByCustIdAndIsUsed(custId, 1);
			cust.setCustDob(DateConvertor.convertToDMY(cust.getCustDob()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return cust;

	}

	@RequestMapping(value = { "/getAllCustList" }, method = RequestMethod.GET)
	public @ResponseBody List<Cust> getAllCustList() {

		List<Cust> custList = new ArrayList<Cust>();

		try {

			custList = custRepo.findByIsUsedOrderByCustIdDesc(1);
			for (int i = 0; i < custList.size(); i++) {
				custList.get(i).setCustDob(DateConvertor.convertToDMY(custList.get(i).getCustDob()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return custList;

	}

	@RequestMapping(value = { "/deleteCust" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteCust(@RequestParam("custId") int custId) {

		Info info = new Info();

		try {
			int delete = custRepo.deleteCust(custId);

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

	// ----------------------------------------Right----------------------------------------------------

	@RequestMapping(value = { "/saveRight" }, method = RequestMethod.POST)
	public @ResponseBody Right saveRight(@RequestBody Right right) {

		Right res = new Right();

		try {

			res = rightRepo.saveAndFlush(right);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getRightByRightId" }, method = RequestMethod.POST)
	public @ResponseBody Right getRightByRightId(@RequestParam("rightId") int rightId) {

		Right right = new Right();

		try {
			right = rightRepo.findByRightIdAndIsUsed(rightId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return right;

	}

	@RequestMapping(value = { "/getAllRightList" }, method = RequestMethod.GET)
	public @ResponseBody List<Right> getAllRightList() {

		List<Right> rightList = new ArrayList<Right>();

		try {

			rightList = rightRepo.findByIsUsedOrderByRightIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return rightList;

	}

	@RequestMapping(value = { "/deleteRight" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteRight(@RequestParam("rightId") int rightId) {

		Info info = new Info();

		try {
			int delete = rightRepo.deleteRight(rightId);

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

	// ----------------------------------------User----------------------------------------------------

	@RequestMapping(value = { "/saveUser" }, method = RequestMethod.POST)
	public @ResponseBody User saveUser(@RequestBody User user) {

		User res = new User();

		try {

			// user.setDate1(DateConvertor.convertToYMD(user.getDate1()));
			res = userRepo.saveAndFlush(user);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getUserByUserId" }, method = RequestMethod.POST)
	public @ResponseBody User getUserByUserId(@RequestParam("userId") int userId) {

		User user = new User();

		try {
			user = userRepo.findByUserIdAndIsUsed(userId, 1);
			user.setUserDob(DateConvertor.convertToDMY(user.getUserDob()));

		} catch (Exception e) {

			e.printStackTrace();

		}
		return user;

	}

	@RequestMapping(value = { "/getAllUserList" }, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUserList() {

		List<User> userList = new ArrayList<User>();

		try {

			userList = userRepo.findByIsUsedOrderByUserIdDesc(1);

			for (int i = 0; i < userList.size(); i++) {
				userList.get(i).setUserDob(DateConvertor.convertToDMY(userList.get(i).getUserDob()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return userList;

	}

	@RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteUser(@RequestParam("userId") int userId) {

		Info info = new Info();

		try {
			int delete = userRepo.deleteUser(userId);

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

	// ----------------------------------------Work Type-----------------------

	@RequestMapping(value = { "/saveWorkType" }, method = RequestMethod.POST)
	public @ResponseBody WorkType saveWorkType(@RequestBody WorkType workType) {

		WorkType res = new WorkType();

		try {
			
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date now =new Date();
			res.setLastUpdateTime(sdf.format(now));

			res = workTypeRepo.saveAndFlush(workType);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = { "/getWorkTypeByWorkTypeId" }, method = RequestMethod.POST)
	public @ResponseBody WorkType getWorkTypeByWorkTypeId(@RequestParam("workTypeId") int workTypeId) {

		WorkType workType = new WorkType();

		try {
			workType = workTypeRepo.findByWorkTypeIdAndIsUsed(workTypeId, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return workType;

	}

	@RequestMapping(value = { "/getAllWorkTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<WorkType> getAllWorkTypeList() {

		List<WorkType> workTypeList = new ArrayList<WorkType>();

		try {

			workTypeList = workTypeRepo.findByIsUsedOrderByWorkTypeIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return workTypeList;

	}

	@RequestMapping(value = { "/deleteWorkType" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteWorkType(@RequestParam("workTypeId") int workTypeId) {

		Info info = new Info();

		try {
			int delete = workTypeRepo.deleteWorkType(workTypeId);

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
}
