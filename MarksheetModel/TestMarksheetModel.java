package MarksheetModel;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {
	
	public static void main(String[] args) throws Exception {
		
		         //testAdd();
		           testUpdate();
	               //  testDelete();
		            //     testGet();
		           //  testSearch();
		                //testGetMeritList();
		
		
		}
	

	
		
		
	private static void testGetMeritList() throws Exception {
		// TODO Auto-generated method stub
		
		MarksheetModel model = new MarksheetModel();
		List<MarksheetBean> list = model.MeritList();
		
		Iterator<MarksheetBean> it = list.iterator();
		while (it.hasNext()) {
			MarksheetBean mb = (MarksheetBean) it.next();
			System.out.print(mb.getId());
			System.out.print("\t" + mb.getRollno());
			System.out.print("\t" + mb.getFname());
			System.out.print("\t" + mb.getLname());
			System.out.print("\t" + mb.getPhysics());
			System.out.print("\t" + mb.getChemistry());
			System.out.println("\t" + mb.getMaths());
		}		
	}





	


	private static void testSearch() throws Exception {
		// TODO Auto-generated method stub
		
		MarksheetModel model = new MarksheetModel();
		List<MarksheetBean> list = model.search();
		Iterator<MarksheetBean> it = list.iterator();
		while (it.hasNext()) {
			MarksheetBean mb = it.next();
			System.out.print(mb.getId());
			System.out.print("\t" + mb.getRollno());
			System.out.print("\t" + mb.getFname());
			System.out.print(" " + mb.getLname());
			System.out.print("\t" + mb.getPhysics());
			System.out.print("\t" + mb.getChemistry());
			System.out.println("\t" + mb.getMaths());

		}

	}


	private static void testGet() throws Exception {
		// TODO Auto-generated method stub
		
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno("102");

		MarksheetModel mm = new MarksheetModel();
		List<MarksheetBean> list = mm.Get(bean);
		Iterator<MarksheetBean> it = list.iterator();
		while (it.hasNext()) {
			MarksheetBean mb =  it.next();
			System.out.print(mb.getId());
			System.out.print("\t" + mb.getRollno());
			System.out.print("\t" + mb.getFname());
			System.out.print("\t" + mb.getLname());
			System.out.print("\t" + mb.getPhysics());
			System.out.print("\t" + mb.getChemistry());
			System.out.println("\t" + mb.getMaths());

		}
	}


	private static void testDelete() throws Exception {
		// TODO Auto-generated method stub
		
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno("106");
		
		MarksheetModel mm= new MarksheetModel();
		mm.Delete(bean);
	
		
	}


	private static void testUpdate() throws Exception {
		// TODO Auto-generated method stub
		
		MarksheetBean bean = new MarksheetBean();
		bean.setRollno("105");
		bean.setFname("pankaj");
		bean.setLname("joshi");
		bean.setPhysics(40); 
		bean.setChemistry(50);
		bean.setMaths(60);
		
		bean.setId(1);
		
		MarksheetModel mm = new MarksheetModel();
		mm.update(bean);

		
		
	}


	private static void testAdd() throws Exception {
		// TODO Auto-generated method stub

		MarksheetBean bean = new MarksheetBean();
		bean.setRollno("108");
		bean.setFname("yug");
		bean.setLname("joshi");
		bean.setPhysics(82); 
		bean.setChemistry(87);
		bean.setMaths(97);

		MarksheetModel model = new MarksheetModel();
		model.add(bean);  
	}

	

}