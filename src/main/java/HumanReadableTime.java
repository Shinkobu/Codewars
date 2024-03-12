public class HumanReadableTime {

    public static void main(String[] args) {
        System.out.println(makeReadable1(5));
        System.out.println(makeReadable1(600));
    }

    public static String makeReadable(int seconds) {
        String tempHours = "00";
        String tempMinutes = "00";
        String tempSeconds = "00";

        tempHours = String.valueOf(seconds/3600);
        if (seconds/3600<10){
            tempHours = "0" + tempHours;
        }
        seconds = seconds % 3600;
        tempMinutes = String.valueOf(seconds/60);
        if (seconds/60<10){
            tempMinutes = "0" + tempMinutes;
        }
        seconds = seconds % 60;
        tempSeconds = String.valueOf(seconds);
        if (seconds<10){
            tempSeconds = "0" + tempSeconds;
        }

        String result = tempHours +":"+ tempMinutes +":"+ tempSeconds;
        return result;
    }

    public static String makeReadable1(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }
}

//https://stackoverflow.com/questions/3377688/what-do-these-symbolic-strings-mean-02d-01d
