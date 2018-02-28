package com.paic.arch.interviews;

import java.sql.Array;

/**
 * Created by Ottack on 2018/2/28.
 */
public class TimeConverterImp implements TimeConverter{
    @Override
    public String convertTime(String aTime) {
        Time time = new Time();
        String result = "";
        //使用spilt截取时间字符串的小时，分钟，秒
        String[] arr = aTime.split(":");
        time.Hour = Integer.parseInt(arr[0]);
        time.Minute = Integer.parseInt(arr[1]);
        time.Second = Integer.parseInt(arr[2]);
        //使用stringBuffer不断的写入字符串
        StringBuffer buffer = new StringBuffer();
        //处理每2秒跳跃一次的第一排灯，偶数为O，奇数为Y
        if((time.Second%2)== 0){
            buffer.append("Y\r\n");
        }
        else{
            buffer.append("O\r\n");
        }
        //处理第二排灯，每个灯代表5个小时，用R表示到了小时数，用O表示未到小时数
        switch (time.Hour/5){
            case 0:
                buffer.append("OOOO\r\n");
                break;
            case 1:
                buffer.append("ROOO\r\n");
                break;
            case 2:
                buffer.append("RROO\r\n");
                break;
            case 3:
                buffer.append("RRRO\r\n");
                break;
            case 4:
                buffer.append("RRRR\r\n");
                break;
        }
        //处理第三排灯，每个灯表示1个小时，用R表示到了小时数，用O标书未到小时数
        switch (time.Hour%5){
            case 0:
                buffer.append("OOOO\r\n");
                break;
            case 1:
                buffer.append("ROOO\r\n");
                break;
            case 2:
                buffer.append("RROO\r\n");
                break;
            case 3:
                buffer.append("RRRO\r\n");
                break;
            case 4:
                buffer.append("RRRR\r\n");
                break;
            default:
                break;
        }
        //处理第四排,有11盏灯，每盏灯代表5分钟，其中第3、第6和第9盏的灯是红色，表示15分、30分和45分，其他的灯为黄色；
        switch (time.Minute/5){
            case 0:
                buffer.append("OOOOOOOOOOO\r\n");
                break;
            case 1:
                buffer.append("YOOOOOOOOOO\r\n");
                break;
            case 2:
                buffer.append("YYOOOOOOOOO\r\n");
                break;
            case 3:
                buffer.append("YYROOOOOOOO\r\n");
                break;
            case 4:
                buffer.append("YYRYOOOOOOO\r\n");
                break;
            case 5:
                buffer.append("YYRYYOOOOOO\r\n");
                break;
            case 6:
                buffer.append("YYRYYROOOOO\r\n");
                break;
            case 7:
                buffer.append("YYRYYRYOOOO\r\n");
                break;
            case 8:
                buffer.append("YYRYYRYYOOO\r\n");
                break;
            case 9:
                buffer.append("YYRYYRYYROO\r\n");
                break;
            case 10:
                buffer.append("YYRYYRYYRYO\r\n");
                break;
            case 11:
                buffer.append("YYRYYRYYRYY\r\n");
                break;
            default:
                break;
        }
        //处理第五排灯,每盏灯代表1分钟,用Y表示到了分钟数，O表示未到分钟数
        switch (time.Minute%5){
            case 0:
                buffer.append("OOOO");
                break;
            case 1:
                buffer.append("YOOO");
                break;
            case 2:
                buffer.append("YYOO");
                break;
            case 3:
                buffer.append("YYYO");
                break;
            case 4:
                buffer.append("YYYY");
                break;
            default:
                break;
        }
        result = buffer.toString();
        return  result;
    }
}
