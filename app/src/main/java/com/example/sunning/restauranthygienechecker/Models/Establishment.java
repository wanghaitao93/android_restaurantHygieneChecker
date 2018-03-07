package com.example.sunning.restauranthygienechecker.Models;

import java.util.List;

public class Establishment {

    /**
     * FHRSID : 1
     * LocalAuthorityBusinessID : sample string 2
     * BusinessName : sample string 3
     * BusinessType : sample string 4
     * BusinessTypeID : 5
     * AddressLine1 : sample string 6
     * AddressLine2 : sample string 7
     * AddressLine3 : sample string 8
     * AddressLine4 : sample string 9
     * PostCode : sample string 10
     * Phone : sample string 11
     * RatingValue : sample string 12
     * RatingKey : sample string 13
     * RatingDate : 2018-03-05T04:09:50.9338215+00:00
     * LocalAuthorityCode : sample string 17
     * LocalAuthorityName : sample string 19
     * LocalAuthorityWebSite : sample string 20
     * LocalAuthorityEmailAddress : sample string 21
     * scores : {"Hygiene":1,"Structural":1,"ConfidenceInManagement":1}
     * SchemeType : sample string 22
     * geocode : {"longitude":"1.1","latitude":"1.1"}
     * RightToReply : sample string 23
     * Distance : 1.1
     * NewRatingPending : true
     * meta : {"dataSource":"sample string 1","extractDate":"2018-03-05T04:09:50.9338215+00:00","itemCount":3,"returncode":"sample string 4","totalCount":5,"totalPages":6,"pageSize":7,"pageNumber":8}
     * links : [{"rel":"sample string 1","href":"sample string 2"},{"rel":"sample string 1","href":"sample string 2"},{"rel":"sample string 1","href":"sample string 2"}]
     */

    private int FHRSID;
    private String LocalAuthorityBusinessID;
    private String BusinessName;
    private String BusinessType;
    private int BusinessTypeID;
    private String AddressLine1;
    private String AddressLine2;
    private String AddressLine3;
    private String AddressLine4;
    private String PostCode;
    private String Phone;
    private String RatingValue;
    private String RatingKey;
    private String RatingDate;
    private String LocalAuthorityCode;
    private String LocalAuthorityName;
    private String LocalAuthorityWebSite;
    private String LocalAuthorityEmailAddress;
    private ScoresBean scores;
    private String SchemeType;
    private GeocodeBean geocode;
    private String RightToReply;
    private double Distance;
    private boolean NewRatingPending;
    private MetaBean meta;
    private List<LinksBean> links;

    public int getFHRSID() {
        return FHRSID;
    }

    public void setFHRSID(int FHRSID) {
        this.FHRSID = FHRSID;
    }

    public String getLocalAuthorityBusinessID() {
        return LocalAuthorityBusinessID;
    }

    public void setLocalAuthorityBusinessID(String LocalAuthorityBusinessID) {
        this.LocalAuthorityBusinessID = LocalAuthorityBusinessID;
    }

    public String getBusinessName() {
        return BusinessName;
    }

    public void setBusinessName(String BusinessName) {
        this.BusinessName = BusinessName;
    }

    public String getBusinessType() {
        return BusinessType;
    }

    public void setBusinessType(String BusinessType) {
        this.BusinessType = BusinessType;
    }

    public int getBusinessTypeID() {
        return BusinessTypeID;
    }

    public void setBusinessTypeID(int BusinessTypeID) {
        this.BusinessTypeID = BusinessTypeID;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }

    public String getAddressLine3() {
        return AddressLine3;
    }

    public void setAddressLine3(String AddressLine3) {
        this.AddressLine3 = AddressLine3;
    }

    public String getAddressLine4() {
        return AddressLine4;
    }

    public void setAddressLine4(String AddressLine4) {
        this.AddressLine4 = AddressLine4;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getRatingValue() {
        return RatingValue;
    }

    public void setRatingValue(String RatingValue) {
        this.RatingValue = RatingValue;
    }

    public String getRatingKey() {
        return RatingKey;
    }

    public void setRatingKey(String RatingKey) {
        this.RatingKey = RatingKey;
    }

    public String getRatingDate() {
        return RatingDate;
    }

    public void setRatingDate(String RatingDate) {
        this.RatingDate = RatingDate;
    }

    public String getLocalAuthorityCode() {
        return LocalAuthorityCode;
    }

    public void setLocalAuthorityCode(String LocalAuthorityCode) {
        this.LocalAuthorityCode = LocalAuthorityCode;
    }

    public String getLocalAuthorityName() {
        return LocalAuthorityName;
    }

    public void setLocalAuthorityName(String LocalAuthorityName) {
        this.LocalAuthorityName = LocalAuthorityName;
    }

    public String getLocalAuthorityWebSite() {
        return LocalAuthorityWebSite;
    }

    public void setLocalAuthorityWebSite(String LocalAuthorityWebSite) {
        this.LocalAuthorityWebSite = LocalAuthorityWebSite;
    }

    public String getLocalAuthorityEmailAddress() {
        return LocalAuthorityEmailAddress;
    }

    public void setLocalAuthorityEmailAddress(String LocalAuthorityEmailAddress) {
        this.LocalAuthorityEmailAddress = LocalAuthorityEmailAddress;
    }

    public ScoresBean getScores() {
        return scores;
    }

    public void setScores(ScoresBean scores) {
        this.scores = scores;
    }

    public String getSchemeType() {
        return SchemeType;
    }

    public void setSchemeType(String SchemeType) {
        this.SchemeType = SchemeType;
    }

    public GeocodeBean getGeocode() {
        return geocode;
    }

    public void setGeocode(GeocodeBean geocode) {
        this.geocode = geocode;
    }

    public String getRightToReply() {
        return RightToReply;
    }

    public void setRightToReply(String RightToReply) {
        this.RightToReply = RightToReply;
    }

    public double getDistance() {
        return Distance;
    }

    public void setDistance(double Distance) {
        this.Distance = Distance;
    }

    public boolean isNewRatingPending() {
        return NewRatingPending;
    }

    public void setNewRatingPending(boolean NewRatingPending) {
        this.NewRatingPending = NewRatingPending;
    }

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<LinksBean> getLinks() {
        return links;
    }

    public void setLinks(List<LinksBean> links) {
        this.links = links;
    }

    public static class ScoresBean {
        /**
         * Hygiene : 1
         * Structural : 1
         * ConfidenceInManagement : 1
         */

        private int Hygiene;
        private int Structural;
        private int ConfidenceInManagement;

        public int getHygiene() {
            return Hygiene;
        }

        public void setHygiene(int Hygiene) {
            this.Hygiene = Hygiene;
        }

        public int getStructural() {
            return Structural;
        }

        public void setStructural(int Structural) {
            this.Structural = Structural;
        }

        public int getConfidenceInManagement() {
            return ConfidenceInManagement;
        }

        public void setConfidenceInManagement(int ConfidenceInManagement) {
            this.ConfidenceInManagement = ConfidenceInManagement;
        }
    }

    public static class GeocodeBean {
        /**
         * longitude : 1.1
         * latitude : 1.1
         */

        private String longitude;
        private String latitude;

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }
    }

    public static class MetaBean {
        /**
         * dataSource : sample string 1
         * extractDate : 2018-03-05T04:09:50.9338215+00:00
         * itemCount : 3
         * returncode : sample string 4
         * totalCount : 5
         * totalPages : 6
         * pageSize : 7
         * pageNumber : 8
         */

        private String dataSource;
        private String extractDate;
        private int itemCount;
        private String returncode;
        private int totalCount;
        private int totalPages;
        private int pageSize;
        private int pageNumber;

        public String getDataSource() {
            return dataSource;
        }

        public void setDataSource(String dataSource) {
            this.dataSource = dataSource;
        }

        public String getExtractDate() {
            return extractDate;
        }

        public void setExtractDate(String extractDate) {
            this.extractDate = extractDate;
        }

        public int getItemCount() {
            return itemCount;
        }

        public void setItemCount(int itemCount) {
            this.itemCount = itemCount;
        }

        public String getReturncode() {
            return returncode;
        }

        public void setReturncode(String returncode) {
            this.returncode = returncode;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNumber() {
            return pageNumber;
        }

        public void setPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
        }
    }

    public static class LinksBean {
        /**
         * rel : sample string 1
         * href : sample string 2
         */

        private String rel;
        private String href;

        public String getRel() {
            return rel;
        }

        public void setRel(String rel) {
            this.rel = rel;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }
    }
}
