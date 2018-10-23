package com.rtowebapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rtowebapi.common.DateConvertor;
import com.rtowebapi.model.GetWork;
import com.rtowebapi.model.GetWorkHeader;
import com.rtowebapi.repo.GetWorkHeaderRepo;
import com.rtowebapi.repo.GetWorkRepo;

@RestController
public class ReportApiController {

	@Autowired
	GetWorkRepo getWorkRepo;

	@Autowired
	GetWorkHeaderRepo getWorkHeaderRepo;

	// -----------Report Between Date----------------

	@RequestMapping(value = { "/getWorkReportBetweenDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWork> getWorkReportBetweenDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("status") int status,
			@RequestParam("workTypeTd") int workTypeTd) {

		List<GetWork> workHeader = new ArrayList<>();

		try {

			if (workTypeTd == 0 && status != 0) {
				workHeader = getWorkRepo.getWorkBetDateAndStatus(fromDate, toDate, status);

			} else if (status == 0 && workTypeTd != 0) {
				workHeader = getWorkRepo.getWorkBetDateAndWorkTypeId(fromDate, toDate, workTypeTd);

			} else {

				workHeader = getWorkRepo.getWorkBetweenDate(fromDate, toDate);
			}

			for (int i = 0; i < workHeader.size(); i++) {
				workHeader.get(i).setDate1(DateConvertor.convertToDMY(workHeader.get(i).getDate1()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return workHeader;

	}

	@RequestMapping(value = { "/getWorkTypeReportBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWork> getWorkTypeReportBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("workTypeTd") int workTypeTd) {

		List<GetWork> workHeader = new ArrayList<>();

		try {

			if (workTypeTd != 0) {
				workHeader = getWorkRepo.getWorkBetDateAndWorkTypeId(fromDate, toDate, workTypeTd);

			} else {

				workHeader = getWorkRepo.getWorkBetweenDate(fromDate, toDate);
			}

			for (int i = 0; i < workHeader.size(); i++) {
				workHeader.get(i).setDate1(DateConvertor.convertToDMY(workHeader.get(i).getDate1()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return workHeader;

	}

	// --------User wise report-----------
	@RequestMapping(value = { "/getUserwiseWorkReportBetDate" }, method = RequestMethod.POST)
	public @ResponseBody List<GetWorkHeader> getUserwiseWorkReportBetDate(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @RequestParam("userId") int userId) {

		List<GetWorkHeader> workHeader = new ArrayList<>();

		try {

			if (userId != 0) {
				workHeader = getWorkHeaderRepo.getWorkBetDateAndUserId(fromDate, toDate, userId);

			} else {

				workHeader = getWorkHeaderRepo.getWorkBetDate(fromDate, toDate);
			}

			for (int i = 0; i < workHeader.size(); i++) {
				workHeader.get(i).setDate1(DateConvertor.convertToDMY(workHeader.get(i).getDate1()));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return workHeader;

	}

}
