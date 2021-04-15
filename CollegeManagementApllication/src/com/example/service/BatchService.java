package com.example.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.batch.BatchDao;

@Path("/BatchService")

public class BatchService {

	BatchDao batchDao = new BatchDao();

	@GET
	@Path("/batch")
	@Produces(MediaType.TEXT_PLAIN)
	public int getCount() {

		System.out.println("accessed");
		return batchDao.getBatchStrength();
	}

}
