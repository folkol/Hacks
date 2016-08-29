// dsl for visitors table
d3.polopoly.toplist.visitors = function (selection, timeSelection, contentId, width, rootUrl, interval, showtrends, noOfRows, showPagination) {
    var table = new d3.polopoly.standardview.table(showtrends, noOfRows, showPagination);
    return table.rootUrl(rootUrl)
                .selection(selection)
                .timeSelection(timeSelection)
                .contentId(contentId)
                .width(width)
                .drillDown(true)
                .dataField("nofVisitors")
                .query("stats?reporttype=visitorstat")
                .pageSize(noOfRows.length)
                .dataRefreshInterval(interval);
};

// dsl for visits table
d3.polopoly.toplist.visits = function (selection, timeSelection, contentId, width, rootUrl, interval, showtrends, noOfRows, showPagination) {
    var table = new d3.polopoly.standardview.table(showtrends, noOfRows, showPagination);
    return table.rootUrl(rootUrl)
                .selection(selection)
                .timeSelection(timeSelection)
                .contentId(contentId)
                .width(width)
                .drillDown(true)
                .dataField("nofVisitsStarted")
                .query("stats?reporttype=visitorstat")
                .pageSize(noOfRows.length)
                .dataRefreshInterval(interval);
};
