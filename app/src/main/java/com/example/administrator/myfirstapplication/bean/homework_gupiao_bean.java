package com.example.administrator.myfirstapplication.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ChenKuiHan on 2016/6/12 0012.
 */
public class homework_gupiao_bean {

    /**
     * errNum : 0
     * errMsg : success
     * retData : {"stockinfo":{"name":"青岛啤酒","code":"00168","date":"2016/06/10 16:01","openningPrice":29.3,"closingPrice":29.2,"hPrice":29.8,"lPrice":28.5,"currentPrice":28.55,"growth":-0.65,"growthPercent":-2.226,"dealnumber":1255999,"turnover":36469333,"52hPrice":50.95,"52lPrice":26.1},"market":{"shanghai":{"name":"上证指数","curdot":2927.159,"curprice":-8.8859,"rate":-0.3,"dealnumber":1430460,"turnover":17737731},"shenzhen":{"name":"深证成指","curdot":10316.82,"curprice":-31.019,"rate":-0.3,"dealnumber":208133522,"turnover":36855377},"DJI":{"name":"道琼斯","date":"2016-06-11 07:33:05","curdot":17865.34,"rate":-0.67,"growth":-119.85,"startdot":17938.82,"closedot":17985.19,"hdot":17938.82,"ldot":17812.34,"turnover":0},"IXIC":{"name":"纳斯达克","date":"2016-06-11 05:40:00","curdot":4894.55,"rate":-1.29,"growth":-64.07,"startdot":4915.15,"closedot":4958.62,"hdot":4917.92,"ldot":4880.61,"turnover":1788746823},"INX":{"name":"纳斯达克","date":"2016-06-11 05:40:00","curdot":2096.07,"rate":-0.92,"growth":-19.41,"startdot":2109.57,"closedot":2115.48,"hdot":2109.57,"ldot":2089.96,"turnover":0},"HSI":{"name":"恒生指数","date":"2016/06/10 16:01","curdot":21042.64,"rate":-1.2,"growth":-255.24,"startdot":21240.08,"closedot":21297.88,"hdot":21270.62,"ldot":21017.98,"turnover":54506497,"52hdot":27470.5,"52ldot":18278.8}}}
     */

    private int errNum;
    private String errMsg;
    /**
     * stockinfo : {"name":"青岛啤酒","code":"00168","date":"2016/06/10 16:01","openningPrice":29.3,"closingPrice":29.2,"hPrice":29.8,"lPrice":28.5,"currentPrice":28.55,"growth":-0.65,"growthPercent":-2.226,"dealnumber":1255999,"turnover":36469333,"52hPrice":50.95,"52lPrice":26.1}
     * market : {"shanghai":{"name":"上证指数","curdot":2927.159,"curprice":-8.8859,"rate":-0.3,"dealnumber":1430460,"turnover":17737731},"shenzhen":{"name":"深证成指","curdot":10316.82,"curprice":-31.019,"rate":-0.3,"dealnumber":208133522,"turnover":36855377},"DJI":{"name":"道琼斯","date":"2016-06-11 07:33:05","curdot":17865.34,"rate":-0.67,"growth":-119.85,"startdot":17938.82,"closedot":17985.19,"hdot":17938.82,"ldot":17812.34,"turnover":0},"IXIC":{"name":"纳斯达克","date":"2016-06-11 05:40:00","curdot":4894.55,"rate":-1.29,"growth":-64.07,"startdot":4915.15,"closedot":4958.62,"hdot":4917.92,"ldot":4880.61,"turnover":1788746823},"INX":{"name":"纳斯达克","date":"2016-06-11 05:40:00","curdot":2096.07,"rate":-0.92,"growth":-19.41,"startdot":2109.57,"closedot":2115.48,"hdot":2109.57,"ldot":2089.96,"turnover":0},"HSI":{"name":"恒生指数","date":"2016/06/10 16:01","curdot":21042.64,"rate":-1.2,"growth":-255.24,"startdot":21240.08,"closedot":21297.88,"hdot":21270.62,"ldot":21017.98,"turnover":54506497,"52hdot":27470.5,"52ldot":18278.8}}
     */

    private RetDataBean retData;

    public int getErrNum() {
        return errNum;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public RetDataBean getRetData() {
        return retData;
    }

    public void setRetData(RetDataBean retData) {
        this.retData = retData;
    }

    public static class RetDataBean {
        /**
         * name : 青岛啤酒
         * code : 00168
         * date : 2016/06/10 16:01
         * openningPrice : 29.3
         * closingPrice : 29.2
         * hPrice : 29.8
         * lPrice : 28.5
         * currentPrice : 28.55
         * growth : -0.65
         * growthPercent : -2.226
         * dealnumber : 1255999
         * turnover : 36469333
         * 52hPrice : 50.95
         * 52lPrice : 26.1
         */

        private StockinfoBean stockinfo;
        /**
         * shanghai : {"name":"上证指数","curdot":2927.159,"curprice":-8.8859,"rate":-0.3,"dealnumber":1430460,"turnover":17737731}
         * shenzhen : {"name":"深证成指","curdot":10316.82,"curprice":-31.019,"rate":-0.3,"dealnumber":208133522,"turnover":36855377}
         * DJI : {"name":"道琼斯","date":"2016-06-11 07:33:05","curdot":17865.34,"rate":-0.67,"growth":-119.85,"startdot":17938.82,"closedot":17985.19,"hdot":17938.82,"ldot":17812.34,"turnover":0}
         * IXIC : {"name":"纳斯达克","date":"2016-06-11 05:40:00","curdot":4894.55,"rate":-1.29,"growth":-64.07,"startdot":4915.15,"closedot":4958.62,"hdot":4917.92,"ldot":4880.61,"turnover":1788746823}
         * INX : {"name":"纳斯达克","date":"2016-06-11 05:40:00","curdot":2096.07,"rate":-0.92,"growth":-19.41,"startdot":2109.57,"closedot":2115.48,"hdot":2109.57,"ldot":2089.96,"turnover":0}
         * HSI : {"name":"恒生指数","date":"2016/06/10 16:01","curdot":21042.64,"rate":-1.2,"growth":-255.24,"startdot":21240.08,"closedot":21297.88,"hdot":21270.62,"ldot":21017.98,"turnover":54506497,"52hdot":27470.5,"52ldot":18278.8}
         */

        private MarketBean market;

        public StockinfoBean getStockinfo() {
            return stockinfo;
        }

        public void setStockinfo(StockinfoBean stockinfo) {
            this.stockinfo = stockinfo;
        }

        public MarketBean getMarket() {
            return market;
        }

        public void setMarket(MarketBean market) {
            this.market = market;
        }

        public static class StockinfoBean {
            private String name;
            private String code;
            private String date;
            private double openningPrice;
            private double closingPrice;
            private double hPrice;
            private double lPrice;
            private double currentPrice;
            private double growth;
            private double growthPercent;
            private int dealnumber;
            private int turnover;
            @SerializedName("52hPrice")
            private double value52hPrice;
            @SerializedName("52lPrice")
            private double value52lPrice;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public double getOpenningPrice() {
                return openningPrice;
            }

            public void setOpenningPrice(double openningPrice) {
                this.openningPrice = openningPrice;
            }

            public double getClosingPrice() {
                return closingPrice;
            }

            public void setClosingPrice(double closingPrice) {
                this.closingPrice = closingPrice;
            }

            public double getHPrice() {
                return hPrice;
            }

            public void setHPrice(double hPrice) {
                this.hPrice = hPrice;
            }

            public double getLPrice() {
                return lPrice;
            }

            public void setLPrice(double lPrice) {
                this.lPrice = lPrice;
            }

            public double getCurrentPrice() {
                return currentPrice;
            }

            public void setCurrentPrice(double currentPrice) {
                this.currentPrice = currentPrice;
            }

            public double getGrowth() {
                return growth;
            }

            public void setGrowth(double growth) {
                this.growth = growth;
            }

            public double getGrowthPercent() {
                return growthPercent;
            }

            public void setGrowthPercent(double growthPercent) {
                this.growthPercent = growthPercent;
            }

            public int getDealnumber() {
                return dealnumber;
            }

            public void setDealnumber(int dealnumber) {
                this.dealnumber = dealnumber;
            }

            public int getTurnover() {
                return turnover;
            }

            public void setTurnover(int turnover) {
                this.turnover = turnover;
            }

            public double getValue52hPrice() {
                return value52hPrice;
            }

            public void setValue52hPrice(double value52hPrice) {
                this.value52hPrice = value52hPrice;
            }

            public double getValue52lPrice() {
                return value52lPrice;
            }

            public void setValue52lPrice(double value52lPrice) {
                this.value52lPrice = value52lPrice;
            }
        }

        public static class MarketBean {
            /**
             * name : 上证指数
             * curdot : 2927.159
             * curprice : -8.8859
             * rate : -0.3
             * dealnumber : 1430460
             * turnover : 17737731
             */

            private ShanghaiBean shanghai;
            /**
             * name : 深证成指
             * curdot : 10316.82
             * curprice : -31.019
             * rate : -0.3
             * dealnumber : 208133522
             * turnover : 36855377
             */

            private ShenzhenBean shenzhen;
            /**
             * name : 道琼斯
             * date : 2016-06-11 07:33:05
             * curdot : 17865.34
             * rate : -0.67
             * growth : -119.85
             * startdot : 17938.82
             * closedot : 17985.19
             * hdot : 17938.82
             * ldot : 17812.34
             * turnover : 0
             */

            private DJIBean DJI;
            /**
             * name : 纳斯达克
             * date : 2016-06-11 05:40:00
             * curdot : 4894.55
             * rate : -1.29
             * growth : -64.07
             * startdot : 4915.15
             * closedot : 4958.62
             * hdot : 4917.92
             * ldot : 4880.61
             * turnover : 1788746823
             */

            private IXICBean IXIC;
            /**
             * name : 纳斯达克
             * date : 2016-06-11 05:40:00
             * curdot : 2096.07
             * rate : -0.92
             * growth : -19.41
             * startdot : 2109.57
             * closedot : 2115.48
             * hdot : 2109.57
             * ldot : 2089.96
             * turnover : 0
             */

            private INXBean INX;
            /**
             * name : 恒生指数
             * date : 2016/06/10 16:01
             * curdot : 21042.64
             * rate : -1.2
             * growth : -255.24
             * startdot : 21240.08
             * closedot : 21297.88
             * hdot : 21270.62
             * ldot : 21017.98
             * turnover : 54506497
             * 52hdot : 27470.5
             * 52ldot : 18278.8
             */

            private HSIBean HSI;

            public ShanghaiBean getShanghai() {
                return shanghai;
            }

            public void setShanghai(ShanghaiBean shanghai) {
                this.shanghai = shanghai;
            }

            public ShenzhenBean getShenzhen() {
                return shenzhen;
            }

            public void setShenzhen(ShenzhenBean shenzhen) {
                this.shenzhen = shenzhen;
            }

            public DJIBean getDJI() {
                return DJI;
            }

            public void setDJI(DJIBean DJI) {
                this.DJI = DJI;
            }

            public IXICBean getIXIC() {
                return IXIC;
            }

            public void setIXIC(IXICBean IXIC) {
                this.IXIC = IXIC;
            }

            public INXBean getINX() {
                return INX;
            }

            public void setINX(INXBean INX) {
                this.INX = INX;
            }

            public HSIBean getHSI() {
                return HSI;
            }

            public void setHSI(HSIBean HSI) {
                this.HSI = HSI;
            }

            public static class ShanghaiBean {
                private String name;
                private double curdot;
                private double curprice;
                private double rate;
                private int dealnumber;
                private int turnover;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getCurprice() {
                    return curprice;
                }

                public void setCurprice(double curprice) {
                    this.curprice = curprice;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public int getDealnumber() {
                    return dealnumber;
                }

                public void setDealnumber(int dealnumber) {
                    this.dealnumber = dealnumber;
                }

                public int getTurnover() {
                    return turnover;
                }

                public void setTurnover(int turnover) {
                    this.turnover = turnover;
                }
            }

            public static class ShenzhenBean {
                private String name;
                private double curdot;
                private double curprice;
                private double rate;
                private int dealnumber;
                private int turnover;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getCurprice() {
                    return curprice;
                }

                public void setCurprice(double curprice) {
                    this.curprice = curprice;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public int getDealnumber() {
                    return dealnumber;
                }

                public void setDealnumber(int dealnumber) {
                    this.dealnumber = dealnumber;
                }

                public int getTurnover() {
                    return turnover;
                }

                public void setTurnover(int turnover) {
                    this.turnover = turnover;
                }
            }

            public static class DJIBean {
                private String name;
                private String date;
                private double curdot;
                private double rate;
                private double growth;
                private double startdot;
                private double closedot;
                private double hdot;
                private double ldot;
                private int turnover;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public double getGrowth() {
                    return growth;
                }

                public void setGrowth(double growth) {
                    this.growth = growth;
                }

                public double getStartdot() {
                    return startdot;
                }

                public void setStartdot(double startdot) {
                    this.startdot = startdot;
                }

                public double getClosedot() {
                    return closedot;
                }

                public void setClosedot(double closedot) {
                    this.closedot = closedot;
                }

                public double getHdot() {
                    return hdot;
                }

                public void setHdot(double hdot) {
                    this.hdot = hdot;
                }

                public double getLdot() {
                    return ldot;
                }

                public void setLdot(double ldot) {
                    this.ldot = ldot;
                }

                public int getTurnover() {
                    return turnover;
                }

                public void setTurnover(int turnover) {
                    this.turnover = turnover;
                }
            }

            public static class IXICBean {
                private String name;
                private String date;
                private double curdot;
                private double rate;
                private double growth;
                private double startdot;
                private double closedot;
                private double hdot;
                private double ldot;
                private int turnover;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public double getGrowth() {
                    return growth;
                }

                public void setGrowth(double growth) {
                    this.growth = growth;
                }

                public double getStartdot() {
                    return startdot;
                }

                public void setStartdot(double startdot) {
                    this.startdot = startdot;
                }

                public double getClosedot() {
                    return closedot;
                }

                public void setClosedot(double closedot) {
                    this.closedot = closedot;
                }

                public double getHdot() {
                    return hdot;
                }

                public void setHdot(double hdot) {
                    this.hdot = hdot;
                }

                public double getLdot() {
                    return ldot;
                }

                public void setLdot(double ldot) {
                    this.ldot = ldot;
                }

                public int getTurnover() {
                    return turnover;
                }

                public void setTurnover(int turnover) {
                    this.turnover = turnover;
                }
            }

            public static class INXBean {
                private String name;
                private String date;
                private double curdot;
                private double rate;
                private double growth;
                private double startdot;
                private double closedot;
                private double hdot;
                private double ldot;
                private int turnover;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public double getGrowth() {
                    return growth;
                }

                public void setGrowth(double growth) {
                    this.growth = growth;
                }

                public double getStartdot() {
                    return startdot;
                }

                public void setStartdot(double startdot) {
                    this.startdot = startdot;
                }

                public double getClosedot() {
                    return closedot;
                }

                public void setClosedot(double closedot) {
                    this.closedot = closedot;
                }

                public double getHdot() {
                    return hdot;
                }

                public void setHdot(double hdot) {
                    this.hdot = hdot;
                }

                public double getLdot() {
                    return ldot;
                }

                public void setLdot(double ldot) {
                    this.ldot = ldot;
                }

                public int getTurnover() {
                    return turnover;
                }

                public void setTurnover(int turnover) {
                    this.turnover = turnover;
                }
            }

            public static class HSIBean {
                private String name;
                private String date;
                private double curdot;
                private double rate;
                private double growth;
                private double startdot;
                private double closedot;
                private double hdot;
                private double ldot;
                private int turnover;
                @SerializedName("52hdot")
                private double value52hdot;
                @SerializedName("52ldot")
                private double value52ldot;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public double getCurdot() {
                    return curdot;
                }

                public void setCurdot(double curdot) {
                    this.curdot = curdot;
                }

                public double getRate() {
                    return rate;
                }

                public void setRate(double rate) {
                    this.rate = rate;
                }

                public double getGrowth() {
                    return growth;
                }

                public void setGrowth(double growth) {
                    this.growth = growth;
                }

                public double getStartdot() {
                    return startdot;
                }

                public void setStartdot(double startdot) {
                    this.startdot = startdot;
                }

                public double getClosedot() {
                    return closedot;
                }

                public void setClosedot(double closedot) {
                    this.closedot = closedot;
                }

                public double getHdot() {
                    return hdot;
                }

                public void setHdot(double hdot) {
                    this.hdot = hdot;
                }

                public double getLdot() {
                    return ldot;
                }

                public void setLdot(double ldot) {
                    this.ldot = ldot;
                }

                public int getTurnover() {
                    return turnover;
                }

                public void setTurnover(int turnover) {
                    this.turnover = turnover;
                }

                public double getValue52hdot() {
                    return value52hdot;
                }

                public void setValue52hdot(double value52hdot) {
                    this.value52hdot = value52hdot;
                }

                public double getValue52ldot() {
                    return value52ldot;
                }

                public void setValue52ldot(double value52ldot) {
                    this.value52ldot = value52ldot;
                }
            }
        }
    }
}
