package test_report.position;

public class Location {
    public int row;
    public int column;
    public double maxValue;

    public static Location LocationLargetst(double[][] param) {
        Location location = new Location();

        location.maxValue = param[0][0];
        for (int i = 0; i < param.length; i++) {
            for (int j = 0; j < param[i].length; j++) {
                if (location.maxValue < param[i][j]) {
                    location.maxValue = param[i][j];
                    location.row=i;
                    location.column=j;
                }
            }
        }
        return location;
    }
};
