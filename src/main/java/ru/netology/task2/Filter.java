package ru.netology.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    private int threshold;

    public Filter(int threshold ) {
        this.threshold  = threshold ;
    }

    public List<Integer> filterOut(List<Integer> list) {
        List<Integer> filteredList = new ArrayList<>();
        int count = 0;

        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");

        for (Integer e : list) {
            if (e >= threshold) {
                logger.log("Элемент " + e + " подходит");
                filteredList.add(e);
                count++;
            } else {
                logger.log("Элемент " + e + " не подходит");
            }
        }

        logger.log("Прошло фильтр " + count + " из " + list.size());

        return filteredList;
    }
}
