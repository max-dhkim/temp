public class main {
    String a = "select '0' as id, date.date::date,coalesce(sell.sum,0) sell, coalesce(fee.sum,0) fee, coalesce(refund.sum,0) refund, 'total' as type\n" +
            "from (select date::date from sales group by date::date) date\n" +
            "left join (select date::date, sum(value) from sales where type='sell' group by date::date) sell on date.date = sell.date\n" +
            "left join (select date::date, sum(value) from sales where type='fee' group by date::date) fee on date.date=fee.date\n" +
            "left join (select date::date, sum(value) from sales where type='refund' group by date::date) refund on date.date= refund.date;";
}
