package com.powernode.mvc.formatter;

import com.powernode.mvc.model.DeviceInfo;
import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.util.Locale;
import java.util.StringJoiner;

public class DeviceFormatter implements Formatter<DeviceInfo> {

    @Override
    public DeviceInfo parse(String text, Locale locale) throws ParseException {
        DeviceInfo deviceInfo = null;
        if (StringUtils.hasLength(text)) {
            String[] items = text.split(";");
            deviceInfo = new DeviceInfo();
            deviceInfo.setItem1(items[0]);
            deviceInfo.setItem2(items[1]);
            deviceInfo.setItem3(items[2]);
            deviceInfo.setItem4(items[3]);
            deviceInfo.setItem5(items[4]);
        }
        return deviceInfo;
    }

    @Override
    public String print(DeviceInfo object, Locale locale) {
        StringJoiner joiner = new StringJoiner("#");
        joiner.add(object.getItem1()).add(object.getItem2())
                .add(object.getItem3()).add(object.getItem4())
                .add(object.getItem5());

        return joiner.toString();
    }
}
