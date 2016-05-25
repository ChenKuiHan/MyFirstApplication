package com.example.administrator.myfirstapplication.bean;

import java.util.List;

/**
 * Created by Administrator on 16-5-24.
 */
public class test_bean {

    /**
     * total : 298
     * result : [{"id":"d5c77cbe-0464-42e8-89b8-142de9ef4372","name":"笔底龙蛇"},{"id":"47d72254-5fc8-442f-b118-1512b4af208c","name":"笔走龙蛇"},{"id":"1f45d96d-0f59-491b-b776-c12da7f5343c","name":"藏龙卧虎"},{"id":"cd9eb88a-a24d-4336-bfd8-17a58589160e","name":"禅世雕龙"},{"id":"a644de5c-1e73-4cd1-b233-593c03dd7e2c","name":"车水马龙"},{"id":"1c14ebaa-ce2e-4313-90b4-7c18dd992d9f","name":"成龙配套"},{"id":"759bdd4c-50de-4a8d-97a6-257c58feddfb","name":"乘龙佳婿"},{"id":"338e79ea-8af0-4f81-a170-c095392493a6","name":"乘龙快婿"},{"id":"f934ea98-ab1e-4bec-a96c-57da8f770520","name":"乘龙配凤"},{"id":"6274359a-4240-4db2-a469-f549524e6ead","name":"打凤捞龙"},{"id":"6855d03d-db66-4c5c-8855-322ab18ce9e6","name":"打凤牢龙"},{"id":"3e59a27f-a86f-4d95-bc89-923b077c4d12","name":"打虎牢龙"},{"id":"1ad0fc61-53ce-493e-a0b0-3a27cb95eaf1","name":"大水冲了龙王庙"},{"id":"075656cf-d5ea-4289-a339-e2dc90c12d9c","name":"得婿如龙"},{"id":"119ed1d3-7525-4ec8-8a3d-556e38fd5edc","name":"骥子龙文"},{"id":"1aaad754-767a-40e5-8c9c-087801c660ba","name":"矫若惊龙"},{"id":"cf9d7cef-c92b-4cfc-a7ed-a34a66bb9573","name":"矫若游龙"},{"id":"384257cb-c3fb-4e23-bdae-9f9ddbb7c645","name":"蛟龙得水"},{"id":"e4c985ba-2033-4b18-8ad4-bfaaf83e872d","name":"蛟龙戏水"},{"id":"4a4cff82-ae20-4e10-829a-f453099d18d5","name":"酒虎诗龙"}]
     * error_code : 0
     * reason : Succes
     */

    private int total;
    private int error_code;
    private String reason;
    /**
     * id : d5c77cbe-0464-42e8-89b8-142de9ef4372
     * name : 笔底龙蛇
     */

    private List<ResultBean> result;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
