package databaseSecurityPhase2;

import java.util.Random;

public class indexes {

	public indexes() {
		// TODO Auto-generated constructor stub
		int tmp = 24345;
		System.out.println(s_id_index("2345"));
		System.out.println(hdate_index("2018-10-01"));
		System.out.println(firstname_index("SuSan"));
	}

	public int generalInt(int s_id, int[] arr) {
		int res = s_id % 100;
		if (res < 20)
			res = arr[0];
		else if (res < 40)
			res = arr[1];
		else if (res < 60)
			res = arr[2];
		else if (res < 80)
			res = arr[3];
		else
			res = arr[4];

		return res;
	}
	
	public int generalString(char c , int[] arr) {
		int res = ((int)c);
		if (res < 53)
			res = arr[0];
		else if (res < 58)
			res = arr[1];
		else if (res < 102)
			res = arr[2];
		else if (res < 107)
			res = arr[3];
		else if (res < 112)
			res = arr[4];
		else if (res < 117)
			res = arr[5];
		else
			res = arr[6];
		return res;

	}
	
	
	public int s_id_index(String s_id) {
		int[] arr = { 80, 3, 15, 2, 37 };
		return generalInt(Integer.valueOf(s_id), arr);
	}

	public int ssid_index(String s_id) {
		int[] arr = { 25, 39, 7, 91, 87 };
		return generalInt(Integer.valueOf(s_id), arr);
	}

	public int rid_index(String s_id) {
		int[] arr = { 83, 78, 64, 59, 43 };
		return generalInt(Integer.valueOf(s_id), arr);
	}

	public int asl_index(String s_id) {
		int[] arr = { 34, 6, 98, 43, 54 };
		return generalInt(Integer.valueOf(s_id), arr);
	}

	public int rsl_index(String s_id) {
		int[] arr = { 83, 35, 30, 65, 9 };
		return generalInt(Integer.valueOf(s_id), arr);
	}

	public int wsl_index(String s_id) {
		int[] arr = { 14, 69, 18, 81, 68 };
		return generalInt(Integer.valueOf(s_id), arr);
	}

	public int ail_index(String s_id) {
		int[] arr = { 45, 59, 32, 88, 78 };
		return generalInt(Integer.valueOf(s_id), arr);
	}

	public int ril_index(String s_id) {
		int[] arr = { 58, 49, 91, 64, 48 };
		return generalInt(Integer.valueOf(s_id), arr);
	}

	public int wil_index(String s_id) {
		int[] arr = { 28, 2, 63, 33, 47 };
		return generalInt(Integer.valueOf(s_id), arr);
	}

	public int age_index(String age) {
		int[] arr = { 8, 32, 29, 92, 12 };
		return generalInt(Integer.valueOf(age) , arr);
	}
	
	public int salary_index(String ssalary) {
		int salary=Integer.valueOf(ssalary);
		int[] arr = { 63 , 42 , 39 , 54 , 73 , 19 , 47 };
		int res = salary % 1000;
		if (res < 150)
			res = arr[0];
		else if (res < 300)
			res = arr[1];
		else if (res < 450)
			res = arr[2];
		else if (res < 600)
			res = arr[3];
		else if (res < 750)
			res = arr[4];
		else if (res < 900)
			res = arr[5];
		else
			res = arr[6];

		return res;
	}
	
	public int firstname_index(String s) {
		int[] arr = { 15, 69 , 57 , 89 , 17 , 90 , 3 };
		return generalString(s.toLowerCase().charAt(0), arr);
	}
	
	public int lastname_index(String s) {
		int[] arr = { 57 , 47 , 1 , 77 , 83 , 36  , 80 };
		return generalString(s.toLowerCase().charAt(0), arr);
	}
	
	public int specialty_index(String s) {
		int[] arr = { 78 , 53 , 15 ,  31 , 94 , 40 , 21 };
		return generalString(s.toLowerCase().charAt(0), arr);
	}
	
	public int hsection_index(String s) {
		int[] arr = { 48 , 93 , 10 , 24 , 63 , 79 , 49 };
		return generalString(s.toLowerCase().charAt(0), arr);
	}
	
	public int username_index(String s) {
		int[] arr = { 22, 37 , 99 , 50 , 86 , 18 , 35 };
		return generalString(s.toLowerCase().charAt(0), arr);
	}
	
	public int illness_index(String s) {
		int[] arr = { 51 , 32 ,64 , 73 , 16 ,99 , 30 };
		return generalString(s.toLowerCase().charAt(0), arr);
	}
	
	public int drugs_index(String s) {
		int[] arr = { 45, 22, 76 ,9 , 61 , 90 , 5};
		return generalString(s.toLowerCase().charAt(0), arr);
	}
	
	public int job_index(String s) {
		int[] arr = { 12 , 53 , 18 , 24 , 36 , 2 , 43 };
		return generalString(s.toLowerCase().charAt(0), arr);
	}
	
	public int pass_index(String s) {
		int[] arr = { 43 , 99 , 37, 26 , 50 , 75 ,38};
		return generalString(s.toLowerCase().charAt(0), arr);
	}
	
	public int hdate_index(String s) {
		int[] arr = { 6 ,62 , 25 , 81 , 60 , 7 };
		String[] ss = s.split("-");
		int res =Integer.valueOf(ss[2]);
		if (res < 5)
			res = arr[0];
		else if (res < 10)
			res = arr[1];
		else if (res < 15)
			res = arr[2];
		else if (res < 20)
			res = arr[3];
		else if (res < 25)
			res = arr[4];
		else 
			res = arr[5];
		return res;
	}
	
	public int generalBinary_index(int status , int[] arr) {
		int rand = new Random().nextInt(3);
		int res =0 ;
		if(status == 0 ){
			res = arr[rand];
		}else{
			res = arr [rand +3];
		}
		return res;
	}
	
	public int mstatus_index(String mstatus ){
		int[]arr = { 4, 36, 77, 35, 3, 8};
		int status = 0 ;
		if(mstatus.compareToIgnoreCase("single")==0){
			status = 1;
		}
		return generalBinary_index(status, arr);
	}
	
	public int gender_index(String gender ){
		int[]arr = { 87 , 42, 21 , 83 , 6, 49};
		int status = 0 ;
		if(gender.compareToIgnoreCase("female")==0){
			status = 1;
		}
		return generalBinary_index(status, arr);
	}
	
	public int isstaff_index(String isstaff ){
		int[]arr = {55 , 84 , 68 , 10 , 71 , 40};
		int status = 0 ;
		if(isstaff.compareToIgnoreCase("yes")==0){
			status = 1;
		}
		return generalBinary_index(status, arr);
	}
	
	public int doctor_index(String s_id) {
		return s_id_index(s_id);
	}
	
	public int nurse_index(String s_id) {
		return s_id_index(s_id);
	}
	
	public static void main(String[] args) {

		new indexes();
	}

}
