package cr.dnc.ns.broom.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

import cr.dnc.ns.broom.domain.Category;
import cr.dnc.ns.broom.domain.Counter;
import cr.dnc.ns.broom.domain.Pair;

public class PairingResponse {
	private final Set<Pair> processedList;
	private final List<Counter> count = new ArrayList<>();
	
	public PairingResponse(Set<Pair> processedList) {
		super();
		this.processedList = processedList;
		updateCounters();
	}
	
	public void updateCounters() {
		count.clear();
		if (processedList != null) {
			Map<Category, Integer> catMap = new HashMap<>();
			BiFunction<Integer, Integer, Integer> mapper = (v1, v2) -> v1 + v2;
			
			for (Pair pair : processedList) {
				catMap.merge(pair.getCategory(), new Integer(1), mapper);
			}
			
			for (Category category : catMap.keySet()) {
				count.add(new Counter(category, catMap.get(category)));
			}
			
			Collections.sort(count);
		}
	}
	
	public Set<Pair> getProcessedList() {
		return this.processedList;
	}
	
	public List<Counter> getCount() {
		return this.count;
	}
}
