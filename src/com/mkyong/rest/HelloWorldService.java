package com.mkyong.rest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;

@Path("/pathInsideJaav")
public class HelloWorldService {

	private static final String FILE_PATH = "D:\\SSL Changes Post Setup.txt";
	private static final String IMAGE_PATH = "C:\\temp\\PSLV\\tbtb\\3202f7f.jpg";

	@GET
	@Path("/{thisParame1FullName}")
	public Response getFullName(@PathParam("thisParame1FullName") String fullName) {

		System.out.println("URL = http://localhost:8080/RESTfulExample/rstful/pathInsideJaav/partik");

		System.out.println("3th Project");
		System.out.println("Before Printing");
		String Name = "Hello Mr. : " + fullName;
		System.out.println("After Printing");

		return Response.status(200).entity(Name).build();
	}

	@GET
	@Path("/anotherParamFirstName")
	public Response getFirstName() {

		System.out.println("http://localhost:8080/RESTfulExample/rstful/pathInsideJaav/anotherParamFirstName");

		System.out.println("4th Project");

		return Response.status(200).entity("First Name = Pratik").build();
	}

	@GET
	@Path("/anotherParamLastName")
	public Response getLastName() {

		System.out.println("http://localhost:8080/RESTfulExample/rstful/pathInsideJaav/anotherParamLastName");

		System.out.println("5th Project");

		return Response.status(200).entity("Last Name = Ambani").build();
	}

	@GET
	@Path("{date}/{month}/{year}")
	public Response getDateOfBirth(@PathParam("date") int date, @PathParam("month") String month,
			@PathParam("year") int year) {

		System.out.println("http://localhost:8080/RESTfulExample/rstful/pathInsideJaav/07/01/1991");
		System.out.println("6th Project");
		String dob = date + "/" + month + "/" + year;

		System.out.println("Your DOB = " + dob);
		return Response.status(200).entity("Your DOB = " + dob).build();

	}

	@GET
	@Path("/rollno")
	public Response getUserDetail(@DefaultValue("20048658") @QueryParam("frm") int frm, @QueryParam("to") int to,
			@QueryParam("orderby") List orderBy) {

		System.out.println("7th Project");
		System.out.println("usingQueryParamToInjectQuery + default value");
		System.out.println(
				"http://localhost:8080/RESTfulExample/rstful/pathInsideJaav/rollno?frm=10&to=100&orderby=name&orderby=rank");
		return Response.status(200).entity("getUserDetail() Called, and Query is = frm: " + frm + " and to: " + to
				+ " and orderby =" + orderBy.toString()).build();
	}

	@GET
	@Path("/rollnos")
	public Response getUserDetails(@Context UriInfo info) {

		System.out.println("8th Project");
		System.out.println("Alternate of 7th");

		String from = info.getQueryParameters().getFirst("from");

		String too = info.getQueryParameters().getFirst("too");
		List orderBy = info.getQueryParameters().get("orderby");

		System.out.println(
				"http://localhost:8080/RESTfulExample/rstful/pathInsideJaav/rollnos?from=23&too=531&orderby=name&orderby=rank");
		return Response.status(200).entity("getUserDetails() Called, and Query is = from: " + from + " and to: " + too
				+ " and orderby =" + orderBy.toString()).build();
	}

	@GET
	@Path("/rollnoMP")
	public Response getUserDetailMP(@DefaultValue("20048658") @MatrixParam("frm") int frm, @MatrixParam("to") int to) {

		// String method = new
		// Object().getClass().getEnclosingMethod().getName();

		System.out.println("9th Project");
		System.out.println("usingMatrixParamToInjectQuery");
		System.out.println("http://localhost:8080/RESTfulExample/rstful/pathInsideJaav/rollnoMP;frm=10;to=44");
		return Response.status(200).entity("getUserDetailMP() Called, and Query is = frm: " + frm + " and to: " + to)
				.build();

	}

	@GET
	@Path("/textfileDownload")
	@Produces("text/plain")
	public Response getFile() {

		System.out.println("http://localhost:8080/RESTfulExample/rstful/pathInsideJaav/textfileDownload");
		File file = new File(FILE_PATH);

		ResponseBuilder rBuilder = Response.ok(file);

		System.out.println("Project - 10");
		System.out.println("Files Name = " + file.getName());

		rBuilder.header("Content-Disposition", "attachment; filename=\" " + file.getName());

		return rBuilder.build();

	}

	@GET
	@Path("/imageDownload")
	@Produces("image/png")
	public Response getImage() {

		System.out.println("http://localhost:8080/RESTfulExample/rstful/pathInsideJaav/imageDownload");
		File file = new File(IMAGE_PATH);

		ResponseBuilder rBuilder = Response.ok(file);

		System.out.println("Project - 11");
		System.out.println("Image Name = " + file.getName());

		rBuilder.header("Content-Disposition", "attachment; filename=\" " + file.getName());

		return rBuilder.build();

	}

}