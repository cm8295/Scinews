package gov.lct.util;

public class PagerService {
	public Pager getPager(String currentPage,String pagerMethod,int totalRows, int pageSize) {
		//	����pager�������ڴ���ҳ��
		Pager pager = new Pager(totalRows, pageSize);
		//	���ǰҳ��Ϊ�գ���ʾΪ�״β�ѯ��ҳ
		//	���Ϊ�գ���ˢ��pager�������뵱ǰҳ�ŵ���Ϣ
		if (currentPage != null) {
			pager.refresh(Integer.parseInt(currentPage));
		}
		//	��ȡ��ǰִ�еķ�������ҳ��ǰһҳ����һҳ��βҳ��
		if (pagerMethod != null) {
			if (pagerMethod.equals("first")) {
				pager.first();
			} else if (pagerMethod.equals("prev")) {
				pager.previous();
			} else if (pagerMethod.equals("next")) {
				pager.next();
			} else if (pagerMethod.equals("last")) {
				pager.last();
			}
		}else if(currentPage!=null){//��ʾָ��ҳ
			pager.setStartRow((Integer.parseInt(currentPage)-1)*pager.getPageSize());
		}
		return pager;
		
	}
}
