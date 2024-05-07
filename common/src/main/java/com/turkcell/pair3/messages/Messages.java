package com.turkcell.pair3.messages;

public class Messages {

    public static class BusinessErrors {
        public static final String NATIONAL_ID_NOT_FOUND = "nationalIdNotFound";
        public static final String CUSTOMER_NOT_FOUND = "customerNotFound";
        public static final String CUSTOMER_ALREADY_EXISTS = "customerAlreadyExists";
        public static final String CUSTOMER_HAS_PRODUCT = "customerHasProduct";
        public static final String CUSTOMER_HAS_NO_PRODUCT = "customerHasNoProduct";
        public static final String PRODUCT_NOT_FOUND = "productNotFound";
        public static final String PRODUCT_ALREADY_EXISTS = "productAlreadyExists";
        public static final String PRODUCT_HAS_CUSTOMER = "productHasCustomer";
        public static final String PRODUCT_HAS_NO_CUSTOMER = "productHasNoCustomer";
        public static final String PRODUCT_HAS_NO_CATEGORY = "productHasNoCategory";
        public static final String BILL_ACCOUNT_NOT_FOUND = "billAccountNotFound";
        public static final String BILL_ACCOUNT_ALREADY_EXISTS = "billAccountAlreadyExists";
        public static final String BILL_ACCOUNT_HAS_PRODUCT = "billAccountHasProduct";
        public static final String BILL_ACCOUNT_HAS_NO_PRODUCT = "billAccountHasNoProduct";
        public static final String BILL_ACCOUNT_HAS_NO_CUSTOMER = "billAccountHasNoCustomer";
        public static final String BILL_ACCOUNT_HAS_CUSTOMER = "billAccountHasCustomer";
        public static final String BILL_ACCOUNT_HAS_NO_BILL = "billAccountHasNoBill";
        public static final String BILL_ACCOUNT_HAS_BILL = "billAccountHasBill";
        public static final String BILL_ACCOUNT_HAS_NO_PAYMENT = "billAccountHasNoPayment";
        public static final String BILL_ACCOUNT_HAS_PAYMENT = "billAccountHasPayment";
        public static final String NATIONAL_ID_ALREADY_EXISTS = "nationalIdAlreadyExists";
        public static final String NO_ADDRESS_FOUND = "noAddressFound";
        public static final String WRONG_USERNAME_OR_PASSWORD = "wrongUsernameOrPassword";
        public static final String NO_USER_FOUND = "noUserFound";
        public static final String USER_ALREADY_EXISTS = "userAlreadyExists";
        public static final String USER_HAS_NO_ROLE = "userHasNoRole";
        public static final String USER_HAS_ROLE = "userHasRole";
        public static final String NO_ROLE_FOUND = "noRoleFound";
        public static final String ROLE_ALREADY_EXISTS = "roleAlreadyExists";
        public static final String NO_CUSTOMER_FOUND = "noCustomerFound";
        public static final String SPECIFICATION_NOT_FOUND = "specificationNotFound";
        public static final String NO_CUSTOMER_FOUND_GIVEN_ID = "noCustomerFoundGivenId";
        public static final String NO_CITY_FOUND_GIVEN_ID = "noCityFoundGivenId";
        public static final String NO_BILL_ACCOUNT_FOUND_GIVEN_ID = "noBillAccountFoundGivenId";
        public static final String NO_PRODUCT_FOUND_GIVEN_ID = "noProductFoundGivenId";
        public static final String ORDER_NOT_FOUND = "orderNotFound";
        public static final String LOGIN_FAILED = "loginFailed";

    }

    public static class ValidationErrors {
        public static final String NOT_BLANK = "{validation.notblank}";
        public static final String NOT_NULL = "{validation.notnull}";
        public static final String SIZE = "{validation.size}";
        public static final String INVALID_NATIONAL_ID = "{validation.invalidNationalId}";
        public static final String INVALID_PHONE_NUMBER = "{validation.invalidPhoneNumber}";
        public static final String INVALID_EMAIL = "{validation.invalidEmail}";
        public static final String INVALID_DATE = "{validation.invalidDate}";
        public static final String INVALID_AMOUNT = "{validation.invalidAmount}";

    }


}
