package com.example.util;

import java.io.PrintWriter;
import java.util.List;

import com.example.model.TopCountModel;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

public class WriteCsvResponse {

	
	public static void writeResponse(PrintWriter writer, List<TopCountModel> topCountModels)  {

        try {

            ColumnPositionMappingStrategy mapStrategy = new ColumnPositionMappingStrategy();

            mapStrategy.setType(TopCountModel.class);
            mapStrategy.generateHeader();

            String[] columns = new String[]{"topString", "topStringCount"};
            mapStrategy.setColumnMapping(columns);

            StatefulBeanToCsv btcsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mapStrategy)
                    .withSeparator(',')
                    .build();

            btcsv.write(topCountModels);

        } catch (CsvException ex) {

            ex.printStackTrace();
        }
    }
}
