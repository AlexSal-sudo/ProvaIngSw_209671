package it.unical.studenti.ProvaIngSw;

import java.util.List;

public class MyListUtil {

	private void ordinamentoCresc(List<Integer> list) {
		
		for(int i =0; i < list.size()-1; ++i) {
			int min = i;
			for(int j = i+1; j < list.size(); ++j) {
				if(list.get(j)<list.get(min))
					min = j;
			}
			int temp = list.get(i);
			list.set(i, list.get(min));
			list.set(min, temp);
		}
	}
	private void ordinamentoDecre(List<Integer> list) {
		
		for(int i =0; i < list.size()-1; ++i) {
			int min = i;
			for(int j = i+1; j < list.size(); ++j) {
				if(list.get(j)>list.get(min))
					min = j;
			}
			int temp = list.get(i);
			list.set(i, list.get(min));
			list.set(min, temp);
		}
	}
	
	public List<Integer> sort(List<Integer> list, int order){
		
		if(list == null)
			throw new NullPointerException("Cannot sort a null list");
		
		if(order > 1)
			throw new IllegalArgumentException("Invalid order");
		
		if(order==0) {
			ordinamentoCresc(list);
		}
		else {
			ordinamentoDecre(list);
		}
		
		return list;
	}
}
