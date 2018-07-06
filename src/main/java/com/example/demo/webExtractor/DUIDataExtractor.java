package com.example.demo.webExtractor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.example.demo.entity.DUICheckPoint;

public class DUIDataExtractor {

	/**
	 * @param url
	 *            website have content
	 * @return checkpoint list
	 * @throws IOException
	 */
	public static List<DUICheckPoint> processScan(String url, int totalPage) throws IOException {
		List<DUICheckPoint> result = new ArrayList<>();
		for (int i = 1; i <= totalPage; i++) {
			Document doc = Jsoup.connect(url + i).get();
			System.out.println("\n\n\n\nWebTitle=" + doc.title());
			
			String tablePattern = "table[cellpadding=4]";
			String rowPattern = "tbody tr";
			String columnPattern = "td";
			
			String countyPattern = "font a b";
			String cityPattern = "font b";
			String locationStringPattern = "a font";
			String timePattern = "font";
			
			Elements table = doc.select(tablePattern);
			// System.out.println(table.toString());
			
			Elements rows = table.select(rowPattern);
			boolean firstRow = true;
			for (Element row : rows) {
				if (firstRow) {
					firstRow = !firstRow;
					continue;
				}
				// process each row
				Elements columns = row.select(columnPattern);
				// process each column to get corresponding data.
				DUICheckPoint cp = new DUICheckPoint();
				cp.setCounty(columns.get(0).select(countyPattern).text());
				cp.setCity(columns.get(1).select(cityPattern).text());
				cp.setLocationOrigin(columns.get(2).select(locationStringPattern).text());
				cp.setTimeString(columns.get(3).select(timePattern).text());
				System.out.println(cp);
				result.add(cp);
			}
		}
		return result;
	}
}
