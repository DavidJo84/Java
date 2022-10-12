package dao;

import dto.MemberDTO;

public class OracleDAO implements DAO_INF {

	@Override
	public void insert(MemberDTO m) {
		System.out.println("오라클저장");
		
	}

}
