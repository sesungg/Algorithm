package com.programmers.Lv1;

import java.util.*;

public class GetReportResults {
    public int[] mySolution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 신고한유저 : 신고당한유저
        LinkedHashMap<String, HashSet<String>> reporter_report = new LinkedHashMap<>();
        // 신고당한유저 : 신고한 유저
        LinkedHashMap<String, HashSet<String>> report_reporter = new LinkedHashMap<>();

        for(int i = 0; i < report.length; i++) {
            // 신고한 유저 아이디
            String id = report[i].substring(0, report[i].indexOf(" "));
            // 신고당한 유저 아이디
            String report_id = report[i].substring(report[i].indexOf(" ") + 1);

            // map에 키가 존재하지 않는다면 키 추가
            if(!reporter_report.containsKey(id)) {
                reporter_report.put(id, new HashSet<String>());
            }
            if(!report_reporter.containsKey(report_id)) {
                report_reporter.put(report_id, new HashSet<String>());
            }

            // 값 가져오기
            HashSet<String> reporte_set = reporter_report.get(id);
            HashSet<String> report_set = report_reporter.get(report_id);

            reporte_set.add(report_id);
            report_set.add(id);

            reporter_report.put(id, reporte_set);
            report_reporter.put(report_id, report_set);
        }

        for(int i = 0; i < id_list.length; i++){
            HashSet<String> set = reporter_report.get(id_list[i]);
            if(set != null) {
                Iterator iter = set.iterator();
                while(iter.hasNext()) {
                    if(report_reporter.get(iter.next()).size() >= k) {
                        answer[i]++;
                    }
                }
            }
        }



        return answer;
    }

    public int[] gptSolution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> userReports = new HashMap<>();
        Map<String, Integer> reportCounts = new HashMap<>();
        Set<String> suspendedUsers = new HashSet<>();

        // Initialize userReports and reportCounts
        for (String id : id_list) {
            userReports.put(id, new HashSet<>());
            reportCounts.put(id, 0);
        }

        // Process the reports and count the number of reports for each user
        for (String r : report) {
            String[] reportInfo = r.split(" ");
            String reporter = reportInfo[0];
            String reported = reportInfo[1];

            // Check if the reporter has already reported the reported user
            if (!userReports.get(reporter).contains(reported)) {
                userReports.get(reporter).add(reported);
                reportCounts.put(reported, reportCounts.get(reported) + 1);
            }
        }

        // Find the suspended users
        for (String id : id_list) {
            if (reportCounts.get(id) >= k) {
                suspendedUsers.add(id);
            }
        }

        // Count the number of emails for each user
        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            Set<String> suspendedReporters = new HashSet<>();

            for (String reporter : userReports.get(id)) {
                if (suspendedUsers.contains(reporter)) {
                    suspendedReporters.add(reporter);
                }
            }

            result[i] = suspendedReporters.size();
        }

        return result;
    }

    public static void main(String[] args) {
        GetReportResults solution = new GetReportResults();

        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k1 = 2;
        int[] result1 = solution.mySolution(id_list1, report1, k1);
        System.out.println(Arrays.toString(result1)); // Output: [2, 1, 1, 0]

        String[] id_list2 = {"con", "ryan"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k2 = 3;
        int[] result2 = solution.mySolution(id_list2, report2, k2);
        System.out.println(Arrays.toString(result2)); // Output: [0, 0]
    }
}
