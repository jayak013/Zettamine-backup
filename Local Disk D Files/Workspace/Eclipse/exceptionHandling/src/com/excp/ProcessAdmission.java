package com.excp;

public class ProcessAdmission {

	public static void main(String[] args) {
		Applicant apl = new Applicant(1538, "Vishal", -1, "ZW");
		try {
			AdmissionsUtil.processAdmission(apl);
		} catch (OverAgeException 
				| InvalidNationalityException
				| NationalityNotAcceptedException | UnderAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
