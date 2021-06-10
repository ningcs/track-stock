package com.ningcs.track.stock.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrackExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFundIsNull() {
            addCriterion("fund is null");
            return (Criteria) this;
        }

        public Criteria andFundIsNotNull() {
            addCriterion("fund is not null");
            return (Criteria) this;
        }

        public Criteria andFundEqualTo(String value) {
            addCriterion("fund =", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundNotEqualTo(String value) {
            addCriterion("fund <>", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundGreaterThan(String value) {
            addCriterion("fund >", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundGreaterThanOrEqualTo(String value) {
            addCriterion("fund >=", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundLessThan(String value) {
            addCriterion("fund <", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundLessThanOrEqualTo(String value) {
            addCriterion("fund <=", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundLike(String value) {
            addCriterion("fund like", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundNotLike(String value) {
            addCriterion("fund not like", value, "fund");
            return (Criteria) this;
        }

        public Criteria andFundIn(List<String> values) {
            addCriterion("fund in", values, "fund");
            return (Criteria) this;
        }

        public Criteria andFundNotIn(List<String> values) {
            addCriterion("fund not in", values, "fund");
            return (Criteria) this;
        }

        public Criteria andFundBetween(String value1, String value2) {
            addCriterion("fund between", value1, value2, "fund");
            return (Criteria) this;
        }

        public Criteria andFundNotBetween(String value1, String value2) {
            addCriterion("fund not between", value1, value2, "fund");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNull() {
            addCriterion("direction is null");
            return (Criteria) this;
        }

        public Criteria andDirectionIsNotNull() {
            addCriterion("direction is not null");
            return (Criteria) this;
        }

        public Criteria andDirectionEqualTo(String value) {
            addCriterion("direction =", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotEqualTo(String value) {
            addCriterion("direction <>", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThan(String value) {
            addCriterion("direction >", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("direction >=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThan(String value) {
            addCriterion("direction <", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLessThanOrEqualTo(String value) {
            addCriterion("direction <=", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionLike(String value) {
            addCriterion("direction like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotLike(String value) {
            addCriterion("direction not like", value, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionIn(List<String> values) {
            addCriterion("direction in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotIn(List<String> values) {
            addCriterion("direction not in", values, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionBetween(String value1, String value2) {
            addCriterion("direction between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andDirectionNotBetween(String value1, String value2) {
            addCriterion("direction not between", value1, value2, "direction");
            return (Criteria) this;
        }

        public Criteria andTickerIsNull() {
            addCriterion("ticker is null");
            return (Criteria) this;
        }

        public Criteria andTickerIsNotNull() {
            addCriterion("ticker is not null");
            return (Criteria) this;
        }

        public Criteria andTickerEqualTo(String value) {
            addCriterion("ticker =", value, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerNotEqualTo(String value) {
            addCriterion("ticker <>", value, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerGreaterThan(String value) {
            addCriterion("ticker >", value, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerGreaterThanOrEqualTo(String value) {
            addCriterion("ticker >=", value, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerLessThan(String value) {
            addCriterion("ticker <", value, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerLessThanOrEqualTo(String value) {
            addCriterion("ticker <=", value, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerLike(String value) {
            addCriterion("ticker like", value, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerNotLike(String value) {
            addCriterion("ticker not like", value, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerIn(List<String> values) {
            addCriterion("ticker in", values, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerNotIn(List<String> values) {
            addCriterion("ticker not in", values, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerBetween(String value1, String value2) {
            addCriterion("ticker between", value1, value2, "ticker");
            return (Criteria) this;
        }

        public Criteria andTickerNotBetween(String value1, String value2) {
            addCriterion("ticker not between", value1, value2, "ticker");
            return (Criteria) this;
        }

        public Criteria andSharesIsNull() {
            addCriterion("shares is null");
            return (Criteria) this;
        }

        public Criteria andSharesIsNotNull() {
            addCriterion("shares is not null");
            return (Criteria) this;
        }

        public Criteria andSharesEqualTo(String value) {
            addCriterion("shares =", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesNotEqualTo(String value) {
            addCriterion("shares <>", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesGreaterThan(String value) {
            addCriterion("shares >", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesGreaterThanOrEqualTo(String value) {
            addCriterion("shares >=", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesLessThan(String value) {
            addCriterion("shares <", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesLessThanOrEqualTo(String value) {
            addCriterion("shares <=", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesLike(String value) {
            addCriterion("shares like", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesNotLike(String value) {
            addCriterion("shares not like", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesIn(List<String> values) {
            addCriterion("shares in", values, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesNotIn(List<String> values) {
            addCriterion("shares not in", values, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesBetween(String value1, String value2) {
            addCriterion("shares between", value1, value2, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesNotBetween(String value1, String value2) {
            addCriterion("shares not between", value1, value2, "shares");
            return (Criteria) this;
        }

        public Criteria andPercentageIsNull() {
            addCriterion("percentage is null");
            return (Criteria) this;
        }

        public Criteria andPercentageIsNotNull() {
            addCriterion("percentage is not null");
            return (Criteria) this;
        }

        public Criteria andPercentageEqualTo(String value) {
            addCriterion("percentage =", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageNotEqualTo(String value) {
            addCriterion("percentage <>", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageGreaterThan(String value) {
            addCriterion("percentage >", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageGreaterThanOrEqualTo(String value) {
            addCriterion("percentage >=", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageLessThan(String value) {
            addCriterion("percentage <", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageLessThanOrEqualTo(String value) {
            addCriterion("percentage <=", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageLike(String value) {
            addCriterion("percentage like", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageNotLike(String value) {
            addCriterion("percentage not like", value, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageIn(List<String> values) {
            addCriterion("percentage in", values, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageNotIn(List<String> values) {
            addCriterion("percentage not in", values, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageBetween(String value1, String value2) {
            addCriterion("percentage between", value1, value2, "percentage");
            return (Criteria) this;
        }

        public Criteria andPercentageNotBetween(String value1, String value2) {
            addCriterion("percentage not between", value1, value2, "percentage");
            return (Criteria) this;
        }

        public Criteria andClosepriceIsNull() {
            addCriterion("closePrice is null");
            return (Criteria) this;
        }

        public Criteria andClosepriceIsNotNull() {
            addCriterion("closePrice is not null");
            return (Criteria) this;
        }

        public Criteria andClosepriceEqualTo(BigDecimal value) {
            addCriterion("closePrice =", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceNotEqualTo(BigDecimal value) {
            addCriterion("closePrice <>", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceGreaterThan(BigDecimal value) {
            addCriterion("closePrice >", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("closePrice >=", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceLessThan(BigDecimal value) {
            addCriterion("closePrice <", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("closePrice <=", value, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceIn(List<BigDecimal> values) {
            addCriterion("closePrice in", values, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceNotIn(List<BigDecimal> values) {
            addCriterion("closePrice not in", values, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("closePrice between", value1, value2, "closeprice");
            return (Criteria) this;
        }

        public Criteria andClosepriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("closePrice not between", value1, value2, "closeprice");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeIsNull() {
            addCriterion("trackingTime is null");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeIsNotNull() {
            addCriterion("trackingTime is not null");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeEqualTo(Date value) {
            addCriterion("trackingTime =", value, "trackingtime");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeNotEqualTo(Date value) {
            addCriterion("trackingTime <>", value, "trackingtime");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeGreaterThan(Date value) {
            addCriterion("trackingTime >", value, "trackingtime");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("trackingTime >=", value, "trackingtime");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeLessThan(Date value) {
            addCriterion("trackingTime <", value, "trackingtime");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeLessThanOrEqualTo(Date value) {
            addCriterion("trackingTime <=", value, "trackingtime");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeIn(List<Date> values) {
            addCriterion("trackingTime in", values, "trackingtime");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeNotIn(List<Date> values) {
            addCriterion("trackingTime not in", values, "trackingtime");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeBetween(Date value1, Date value2) {
            addCriterion("trackingTime between", value1, value2, "trackingtime");
            return (Criteria) this;
        }

        public Criteria andTrackingtimeNotBetween(Date value1, Date value2) {
            addCriterion("trackingTime not between", value1, value2, "trackingtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}