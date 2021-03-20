package ru.clevertec.checksystem.core.constant;

public class Entities {

    protected Entities() {
    }

    public static final class Table {
        public static final String EMAILS = "emails";
        public static final String EVENT_EMAILS = "event_emails";
        public static final String PRODUCTS = "products";
        public static final String RECEIPTS = "receipts";
        public static final String RECEIPT_DISCOUNTS = "receipt_discounts";
        public static final String SIMPLE_CONSTANT_RECEIPT_DISCOUNT = "simple_constant_receipt_discounts";
        public static final String SIMPLE_PERCENTAGE_RECEIPT_DISCOUNT = "simple_percentage_receipt_discounts";
        public static final String RECEIPT_ITEMS = "receipt_items";
        public static final String RECEIPT_ITEM_DISCOUNTS = "receipt_item_discounts";
        public static final String SIMPLE_CONSTANT_RECEIPT_ITEM_DISCOUNT = "simple_constant_receipt_item_discounts";
        public static final String SIMPLE_PERCENTAGE_RECEIPT_ITEM_DISCOUNT = "simple_percentage_receipt_item_discounts";
        public static final String THRESHOLD_PERCENTAGE_RECEIPT_ITEM_DISCOUNT = "threshold_percentage_receipt_item_discounts";
        public static final String RECEIPT__RECEIPT_DISCOUNT = "_receipt__receipt_discount";
        public static final String RECEIPT_ITEM__RECEIPT_ITEM_DISCOUNT = "_receipt_item__receipt_item_discount";
    }

    public static final class Column {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String DESCRIPTION = "description";
        public static final String ADDRESS = "address";
        public static final String CASHIER = "cashier";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String DATE = "date";
        public static final String PRICE = "price";
        public static final String CONSTANT = "constant";
        public static final String PERCENT = "percent";
        public static final String THRESHOLD = "threshold";
        public static final String QUANTITY = "quantity";
        public static final String EVENT_TYPE = "event_type";
    }

    public static final class JoinColumn {
        public static final String PRODUCT_ID = "product_id";
        public static final String RECEIPT_ID = "receipt_id";
        public static final String EMAIL_ID = "email_id";
        public static final String RECEIPT_ITEM_ID = "receipt_item_id";
        public static final String RECEIPT_DISCOUNT_ID = "receipt_discount_id";
        public static final String RECEIPT_ITEM_DISCOUNT_ID = "receipt_item_discount_id";
        public static final String DEPENDENT_DISCOUNT_ID = "dependent_discount_id";
    }

    public static final class DiscriminatorValues {
        public static final String SIMPLE_PERCENTAGE_RECEIPT_DISCOUNT = "SimplePercentageReceiptDiscount";
        public static final String SIMPLE_CONSTANT_RECEIPT_DISCOUNT = "SimpleConstantReceiptDiscount";
        public static final String SIMPLE_CONSTANT_RECEIPT_ITEM_DISCOUNT = "SimpleConstantReceiptItemDiscount";
        public static final String SIMPLE_PERCENTAGE_RECEIPT_ITEM_DISCOUNT = "SimplePercentageReceiptItemDiscount";
        public static final String THRESHOLD_PERCENTAGE_RECEIPT_ITEM_DISCOUNT = "ThresholdPercentageReceiptItemDiscount";
    }

    public static final class DiscriminatorNames {
        public static final String RECEIPT_DISCOUNT = "type";
        public static final String RECEIPT_ITEM_DISCOUNT = "type";
    }

}
