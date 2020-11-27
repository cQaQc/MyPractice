package simpleFactry;

public class ChartFactory {
    public static Chart getChart(String type){
        Chart chart = null;
        if(type.equalsIgnoreCase("histogram")){
            chart = new HistogramChart();
            System.out.println("初始化柱状图");
            return chart;
        }

        if(type.equalsIgnoreCase("pie")){
            chart = new PieChart();
            System.out.println("初始化饼状图");
            return chart;
        }

        return null;
    }
}
