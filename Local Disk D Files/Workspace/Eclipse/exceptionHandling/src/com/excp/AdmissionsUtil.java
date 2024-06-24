package com.excp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class AdmissionsUtil {
	
	private static final String ADMISSION_PROPERTIES = "admission.properties";
	private static final String ACCEPTED_NATIONALITY = "acceptedNationality";
	private static final String MAX_AGE = "maxAge";
	private static final String MIN_AGE = "minAge";
	private static Properties admissionProperties;
	private static List<String> nationalities;
	//to load only once. As the properties are same for all the Applicant objects.
	//The below static block is created for that purpose
	static {
		try {
			FileReader reader = new FileReader(ADMISSION_PROPERTIES);
			admissionProperties = new Properties();
			admissionProperties.load(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void processAdmission(Applicant apl) 
			throws UnderAgeException, 
				OverAgeException, 
				InvalidNationalityException, 
				NationalityNotAcceptedException {
		nationalities = new ArrayList<String>();
		
		for(String s:admissionProperties
				.getProperty(ACCEPTED_NATIONALITY).split(",")) {
			nationalities.add(s);
		}
		
		StringBuffer mesg = new StringBuffer();
		
		
		if(apl.getAge() < 0) {
			// raise NegativeAgeException
			mesg.append("A negative value for age ( ")
			.append(apl.getAge()).append(" ) is not acceptable");
			throw new NegativeValueException(mesg.toString());
			
		}else if(apl.getAge() < Integer.parseInt(
				admissionProperties.getProperty(MIN_AGE))) {
			//raise UnderAgeException
			mesg.append("Applicant age ( ")
			.append(apl.getAge()).append(" ) is below the Minimum Age");
			throw new UnderAgeException(mesg.toString());
		}else if(apl.getAge() > Integer.parseInt(
				admissionProperties.getProperty(MAX_AGE))) {
			//raise OverAgeException
			mesg.append("Applicant age ( ")
			.append(apl.getAge()).append(" ) is above the Maximum Age");
			throw new OverAgeException(mesg.toString());
			
		}
		
//		else if(!CountryISOCodes.contains(apl.getNationality())) {
//			//raise InvalidNationalityException
//			mesg.append(apl.getNationality())
//			.append(" is an invalid value for Country ISO Codes");
//			throw new InvalidNationalityException(mesg.toString());
//		}
		
		
		else if(!CountryISOCodes.contains(apl.getNationality())) {
			mesg.append(apl.getNationality())
			.append(" is an invalid value for Country ISO Codes");
			throw new InvalidNationalityException(mesg.toString());
		}
		
		else if(!nationalities.contains(apl.getNationality())) {
			//raise not acceptable nationality exception
			mesg.append(apl.getNationality())
			.append(" is not an accepted Nationality for this application");
			throw new NationalityNotAcceptedException(mesg.toString());
		}

		
		System.out.println("Admission processed for " + apl
				+"\t"
				+ CountryISOCodes.getValue(apl.getNationality()));
	}

}
