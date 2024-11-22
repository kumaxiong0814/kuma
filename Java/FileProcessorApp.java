package com.a;

import java.io.*;
import java.util.*;

public class FileProcessorApp {

    public static void main(String[] args) {
        // 输入和输出目录
        String inputFolder = "C:\\Users\\e-ls-dev-315\\Desktop\\Test\\input\\" ;
        String outputFolder = "C:\\Users\\e-ls-dev-315\\Desktop\\Test\\output\\" ;
        
        // 确保输出目录存在
        File outputDir = new File(outputFolder);
        if (!outputDir.exists() && !outputDir.mkdirs()) {
            System.err.println("输出文件夹创建失败：" + outputFolder);
            return;
        }

        // 配置每个文件的字段定义
        Map<String, FieldConfig> fieldConfigMap = new HashMap<>();
        fieldConfigMap.put("0263", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"InventoryItemSegment1" , "40"},
        	{"ShippedDate" , "8"},
        	{"DeliveryPlanDate" , "8"},
        	{"OrderedQuantity" , ""},
        	{"OrigSysDocumentRef" , "50"},
        	{"OrganizationCode" , "3"},
        	{"SecondaryInventoryName" , "10"},
        	{"CustomerNumber" , "8"},
        	{"WholesaleunitPrice" , ""}
        }));
        fieldConfigMap.put("0264", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"ORDER_NO" , "40"},
        	{"NOT_ENCUMBER_MAKE_KBN" , "1"},
        	{"SINGLE_ENCUMBER_KBN" , "1"},
        	{"SHIPPED_KBN" , "1"},
        	{"DESCRIPTION_HEDDER" , "240"},
        	{"TRANSACTION_TYPE_NAME" , "30"},
        	{"FROM_ORGANIZATION_CODE" , "3"},
        	{"FROM_SUBINVENTORY_CODE" , "10"},
        	{"FROM_LOCATOR_CODE" , "40"},
        	{"TO_ORGANIZATION_CODE" , "3"},
        	{"TO_SUBINVENTORY_CODE" , "10"},
        	{"TO_LOCATOR_CODE" , "40"},
        	{"INVENTORY_ITEM_CODE" , "40"},
        	{"PRIMARY_UNIT_OF_MEASURE" , "25"},
        	{"SHIPPED_QUANTITY" , ""},
        	{"SHIPPING_DATE" , "8"},
        	{"SHIPPED_DATE" , "8"},
        	{"RECEIVING_DATE" , "8"},
        	{"URGENT_FLAG" , "3"},
        	{"DESCRIPTION_LINE" , "240"}
        }));
        fieldConfigMap.put("0266", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"ShipmentId" , "6"},
        	{"ShipmentLineNum" , ""},
        	{"ReceiveQuantity" , ""},
        	{"DateReceived" , ""},
        	{"ReceiptOrganization" , "3"},
        	{"ReceiptStorageLocation" , "10"}
        }));
        fieldConfigMap.put("0270", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
        	{"ContractNumber" , "10"},
        	{"ModelCode" , "8"},
        	{"InventSerialId" , "10"},
        	{"ModelName" , "8"},
        	{"TerritoryCode" , "9"},
        	{"TerritoryControl" , "3"},
        	{"ReceiptDate" , "8"},
        	{"ItemId1" , "8"},
        	{"Quantity1" , "1"},
        	{"ItemId2" , "8"},
        	{"Quantity2" , "1"},
        	{"ItemId3" , "8"},
        	{"Quantity3" , "1"},
        	{"ItemId4" , "8"},
        	{"Quantity4" , "1"},
        	{"ItemId5" , "8"},
        	{"Quantity5" , "1"},
        	{"ItemId6" , "8"},
        	{"Quantity6" , "1"},
        	{"ItemId7" , "8"},
        	{"Quantity7" , "1"},
        	{"ItemId8" , "8"},
        	{"Quantity8" , "1"},
        	{"ItemId9" , "8"},
        	{"Quantity9" , "1"},
        	{"ItemId10" , "8"},
        	{"Quantity10" , "1"},
        	{"ItemId11" , "8"},
        	{"Quantity11" , "1"},
        	{"ItemId12" , "8"},
        	{"Quantity12" , "1"},
        	{"ItemId13" , "8"},
        	{"Quantity13" , "1"},
        	{"ItemId14" , "8"},
        	{"Quantity14" , "1"},
        	{"ItemId15" , "8"},
        	{"Quantity15" , "1"},
        	{"ItemId16" , "8"},
        	{"Quantity16" , "1"},
        	{"ItemId17" , "8"},
        	{"Quantity17" , "1"},
        	{"ItemId18" , "8"},
        	{"Quantity18" , "1"},
        	{"ItemId19" , "8"},
        	{"Quantity19" , "1"},
        	{"ItemId20" , "8"},
        	{"Quantity20" , "1"},
        	{"PhoneNumber" , "12"},
        	{"RequesterName" , "20"},
        	{"Remarks" , "120"}
        }));
        fieldConfigMap.put("0275", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
        	 {"ContractNumber", "10"},
             {"DeliveryScheduledDate", "8"},
             {"AutoReplenishmentNumber", "7"},
             {"OrderSourceName", "2"},
             {"SpecifiedTime", "9"},
             {"UrgentFlag", "1"},
             {"CollectionFlag", "1"},
             {"NextVisitDate", "8"},
             {"SalesResponsibleName", "20"},
             {"BuildingName", "34"},
             {"ShipToFloor", "6"},
             {"ShipToDivision", "40"},
             {"OrdererName", "20"},
             {"DeliveryToNotes", "60"},
             {"SalesOrderNotes", "60"},
             {"NumberOfLines", "2"},
             {"ItemCode01", "14"},
             {"Quantity01", "7"},
             {"ItemCode02", "14"},
             {"Quantity02", "7"},
             {"ItemCode03", "14"},
             {"Quantity03", "7"},
             {"ItemCode04", "14"},
             {"Quantity04", "7"},
             {"ItemCode05", "14"},
             {"Quantity05", "7"},
             {"ItemCode06", "14"},
             {"Quantity06", "7"},
             {"ItemCode07", "14"},
             {"Quantity07", "7"},
             {"ItemCode08", "14"},
             {"Quantity08", "7"},
             {"ItemCode09", "14"},
             {"Quantity09", "7"},
             {"ItemCode10", "14"},
             {"Quantity10", "7"},
             {"ItemCode11", "14"},
             {"Quantity11", "7"},
             {"ItemCode12", "14"},
             {"Quantity12", "7"},
             {"ItemCode13", "14"},
             {"Quantity13", "7"},
             {"ItemCode14", "14"},
             {"Quantity14", "7"},
             {"ItemCode15", "14"},
             {"Quantity15", "7"}
        }));
        fieldConfigMap.put("0278", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"ShipmentId" , "6"},
        	{"ShipmentLineNum" , ""},
        	{"ItemCode" , "40"},
        	{"LogisInstrQuantity" , ""},
        	{"ShippedDate" , "8"},
        	{"InventOrganization" , "20"},
        	{"SubInventoryCode" , "10"},
        	{"DeliveryDate" , "8"}
       }));
        fieldConfigMap.put("0281", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
        	{"ShipmentId" , "6"},
    		{"ShipmentLineNum" , "10"},
    		{"ItemId" , "14"},
    		{"InventSerialId" , "10"},
    		{"LastCategory" , "2"},
    		{"UnicornCategory" , "3"},
    		{"LastCategoryProcessingClassification" , "1"},
    		{"ProductionClass" , "1"},
    		{"DRClass" , "1"},
    		{"UA5Class" , "1"},
    		{"SpecialCollectionFlag" , "1"},
    		{"ScheduledWorkDate" , "8"},
    		{"AddCVJudgement1" , "5"},
    		{"AddCVJudgement2" , "1"},
    		{"InstallationPeriodDetermination" , "2"},
    		{"InstallationDays" , "10"},
    		{"AROWarehouseCollection" , "1"}
        }));
        fieldConfigMap.put("0288", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
        	{"OrderSourceName" , "3"},
        	{"RequestDate" , "10"},
        	{"SerialNumber" , "6"},
        	{"ContractNumber" , "10"},
        	{"Segment1" , "8"},
        	{"ShipToName" , "40"},
        	{"ShipToDivision" , "40"},
        	{"OrigSysDocumentRef" , "20"},
        	{"IncidentNumber" , "20"},
        	{"OrderedInstructions" , "60"},
        	{"ShippingInstructions" , "168"},
        	{"OrderContact" , "20"},
        	{"CustomerTelNumber" , "12"},
        	{"ShipToAddressNum" , "44"},
        	{"ShipToBuilding" , "40"},
        	{"ShipToFloor" , "6"},
        	{"ShipToAddress" , "100"},
        	{"ItemId1" , "14"},
        	{"SalesQty1" , "7"},
        	{"ItemId2" , "14"},
        	{"SalesQty2" , "7"},
        	{"ItemId3" , "14"},
        	{"SalesQty3" , "7"},
        	{"ItemId4" , "14"},
        	{"SalesQty4" , "7"},
        	{"ItemId5" , "14"},
        	{"SalesQty5" , "7"},
        	{"ItemId6" , "14"},
        	{"SalesQty6" , "7"},
        	{"ItemId7" , "14"},
        	{"SalesQty7" , "7"},
        	{"ItemId8" , "14"},
        	{"SalesQty8" , "7"},
        	{"ItemId9" , "14"},
        	{"SalesQty9" , "7"},
        	{"ItemId10" , "14"},
        	{"SalesQty10" , "7"},
        	{"ItemId11" , "14"},
        	{"SalesQty11" , "7"},
        	{"ItemId12" , "14"},
        	{"SalesQty12" , "7"},
        	{"ItemId13" , "14"},
        	{"SalesQty13" , "7"},
        	{"ItemId14" , "14"},
        	{"SalesQty14" , "7"},
        	{"ItemId15" , "14"},
        	{"SalesQty15" , "7"},
        	{"ItemId16" , "14"},
        	{"SalesQty16" , "7"},
        	{"ItemId17" , "14"},
        	{"SalesQty17" , "7"},
        	{"ItemId18" , "14"},
        	{"SalesQty18" , "7"},
        	{"ItemId19" , "14"},
        	{"SalesQty19" , "7"},
        	{"ItemId20" , "14"},
        	{"SalesQty20" , "7"}
//        	{"ExtraFields" , "1"}
        }));
        fieldConfigMap.put("0290", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
        {"FromImportSystem" , "3"},
		{"ProcessDate" , "14"},
		{"InvoiceNo" , "12"},
		{"CustomerPONo1" , "20"},
		{"PartNo" , "13"},
		{"UnitPrice" , "17"},
		{"CurrencyCode" , "3"},
		{"LastCustOrderPrice" , "17"},
		{"LastCustOrderCurrency" , "3"},
		{"Quantity" , "8"},
		{"IncotermsCode" , "5"},
		{"FOBDueDate" , "8"},
		{"ShipMode" , "1"},
		{"ReservationInventLocationId" , "5"},
		{"PayFreeType" , "1"},
		{"FBPurchOrderNum" , "20"},
		{"Remarks1" , "30"},
		{"IntermediaryTradeType" , "1"},
		{"LastCustMIMECode" , "3"},
		{"ChargeDeptCode" , "8"},
		{"ChargeDeptCode2" , "8"},
		{"ChargeDeptCode3" , "8"},
		{"ProjectCode1" , "5"},
		{"ProjectCode2" , "5"},
		{"ProjectCode3" , "5"},
		{"VendorSiteCode" , "10"},
		{"AccountDeptCode" , "8"},
		{"LastCustProductCode" , "14"}
        }));
        fieldConfigMap.put("0292", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
        	{"FromImportSystem" , "3"},
    		{"InvoiceNo" , "12"},
    		{"PartNo" , "13"},
    		{"LastCustMIMECode" , "3"},
    		{"CustomerPONo1" , "20"},
    		{"SpareModelCode" , "2"},
    		{"Quantity" , "9"},
    		{"UnitPrice" , "17"},
    		{"CurrencyCode" , "3"},
    		{"NETWeight" , "11"},
    		{"-" , "30"},
    		{"SpareModelName" , "10"},
    		{"-" , "8"},
    		{"-" , "8"},
    		{"-" , "1"},
    		{"LastCustOrderPrice" , "17"},
    		{"LastCustOrderCurrency" , "3"},
    		{"-" , "3"},
    		{"OriginCode" , "3"},
    		{"ProcessDate" , "14"},
    		{"ReservationInventLocationId" , "5"},
    		{"-" , "8"},
    		{"ShipMode" , "1"},
    		{"IncotermsCode" , "5"},
    		{"VanningInventLocationId" , "5"},
    		{"FASDueDate" , "8"},
    		{"FOBDueDate" , "8"},
    		{"CustItemCode" , "14"},
    		{"PTANo" , "20"},
    		{"ChargeDeptCode" , "8"},
    		{"ChargeDeptCode2" , "8"},
    		{"ChargeDeptCode3" , "8"},
    		{"ProjectCode1" , "5"},
    		{"ProjectCode2" , "5"},
    		{"ProjectCode3" , "5"},
    		{"NETWeightUom" , "3"},
    		{"CustomerPONo2" , "20"}
        }));
        fieldConfigMap.put("0295", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        {"OrderImportKey" , "20"},
		{"" , "3"},
		{"ProcessDate" , "14"},
		{"Seq" , "4"},
		{"InvoiceNo" , "12"},
		{"CustomerPONo1" , "20"},
		{"CustomerPONo2" , "20"},
		{"CustomerPONo3" , "20"},
		{"CustomerPONo4" , "20"},
		{"CustomerPONo5" , "20"},
		{"PartNo" , "14"},
		{"ProductCode" , "8"},
		{"CurrencyCode" , "3"},
		{"Quantity" , "8"},
		{"RegularUrgentType" , "1"},
		{"IncotermsCode" , "5"},
		{"FASDueDate" , "8"},
		{"FASCutDate" , "8"},
		{"FOBDueDate" , "8"},
		{"ShipMode" , "1"},
		{"FreightPayCode" , "1"},
		{"PayFreeType" , "1"},
		{"StillReceiptFlag" , "1"},
		{"AccountDeptCode" , "8"},
		{"PTANo" , "20"},
		{"ReservationInventLocationId" , "5"},
		{"VanningInventLocationId" , "5"},
		{"LastCustMIMECode" , "3"},
		{"PricingTermCode" , "5"},
		{"IntermediaryTradeType" , "1"},
		{"AddCalCode" , "2"},
		{"FBPurchOrderNum" , "20"},
		{"ChargeDeptCode" , "8"},
		{"ChargeDeptCode2" , "8"},
		{"ChargeDeptCode3" , "8"},
		{"ProjectCode1" , "5"},
		{"ProjectCode2" , "5"},
		{"ProjectCode3" , "5"},
		{"VendorSiteCode" , "10"}
        }));
        fieldConfigMap.put("0312", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
        	{"GroupingOrder" , "40"},
    		{"NotEncumberMakeDivision" , "1"},
    		{"PartiallyReservableDivision" , "1"},
    		{"ShippedDevision" , "1"},
    		{"ShipmentId" , "6"},
    		{"ShipmentLineNum" , "2"},
    		{"HeaderComent" , "240"},
    		{"TransactionType" , "20"},
    		{"ShipInventOrganization" , "3"},
    		{"ShiptStorageLocation" , "5"},
    		{"ShipLocation" , "6"},
    		{"ReceiptInventOrganization" , "3"},
    		{"ReceiptStorageLocation" , "5"},
    		{"ReceiptLocation" , "6"},
    		{"ItemCode" , "13"},
    		{"QtyShipped" , "8"},
    		{"ExpectedShipDate" , "8"},
    		{"ShipDate" , "8"},
    		{"ExpectedReceiveDate" , "8"},
    		{"UrgentFlag" , "3"},
    		{"LineComent" , "240"}
        }));
        fieldConfigMap.put("0313", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"OrderImportKey" , "20"},
    		{"" , "3"},
    		{"ProcessDate" , "14"},
    		{"Seq" , "4"},
    		{"InvoiceNo" , "12"},
    		{"CustomerPONo1" , "20"},
    		{"CustomerPONo2" , "20"},
    		{"CustomerPONo3" , "20"},
    		{"CustomerPONo4" , "20"},
    		{"CustomerPONo5" , "20"},
    		{"OrderedDate" , "8"},
    		{"CustMIMECode" , "3"},
    		{"PartNo" , "14"},
    		{"ProductCode" , "8"},
    		{"CustItemCode" , "14"},
    		{"UnitPrice" , "16"},
    		{"CurrencyCode" , "3"},
    		{"LastCustOrderPrice" , "16"},
    		{"LastCustOrderCurrency" , "3"},
    		{"Quantity" , "8"},
    		{"OrderQtyUOM" , "3"},
    		{"RegularUrgentType" , "1"},
    		{"FCLType" , "3"},
    		{"IncotermsCode" , "5"},
    		{"DeliveryDueDate" , "8"},
    		{"FASDueDate" , "8"},
    		{"FOBDueDate" , "8"},
    		{"ShipMode" , "1"},
    		{"FreightPayCode" , "1"},
    		{"PayFreeType" , "1"},
    		{"StillReceiptFlag" , "1"},
    		{"SourceCode" , "3"},
    		{"AccountDeptCode" , "8"},
    		{"PTANo" , "20"},
    		{"LOS" , "1"},
    		{"ReservationInventLocationId" , "5"},
    		{"VanningInventLocationId" , "5"},
    		{"LastCustMIMECode" , "3"},
    		{"LastCustProductCode" , "14"},
    		{"LastCustProductName" , "35"},
    		{"PricingTermCode" , "5"},
    		{"PricingTermName" , "15"},
    		{"PricingTermPlaceCode" , "5"},
    		{"PricingTermPlaceName" , "35"},
    		{"TradingTermPlaceCode" , "5"},
    		{"TradingTermPlaceName" , "35"},
    		{"IntermediaryTradeType" , "1"},
    		{"InvoicePersonCode" , "10"},
    		{"InvoiceCreationDate" , "8"},
    		{"Vessel" , "30"},
    		{"LoadingCode" , "5"},
    		{"DestinationCode" , "5"},
    		{"InvoiceTitleCode" , "14"},
    		{"CORemarks1" , "35"},
    		{"CORemarks2" , "35"},
    		{"CORemarks3" , "35"},
    		{"CORemarks4" , "35"},
    		{"CORemarks5" , "35"},
    		{"CORemarks6" , "35"},
    		{"TotalPackQty" , "8"},
    		{"TotalPackCode" , "3"},
    		{"InsidePackQty" , "35"},
    		{"AddCalCode" , "2"},
    		{"Remarks1" , "30"},
    		{"Remarks2" , "30"},
    		{"Remarks3" , "30"},
    		{"Remarks4" , "30"},
    		{"Remarks5" , "30"},
    		{"Remarks6" , "30"},
    		{"Remarks7" , "30"},
    		{"Remarks8" , "30"},
    		{"Remarks9" , "30"},
    		{"Remarks10" , "30"},
    		{"Remarks11" , "30"},
    		{"Remarks12" , "30"},
    		{"Remarks13" , "30"},
    		{"Remarks14" , "30"},
    		{"Remarks15" , "30"},
    		{"Remarks16" , "30"},
    		{"Remarks17" , "30"},
    		{"Remarks18" , "30"},
    		{"Remarks19" , "30"},
    		{"Remarks20" , "30"},
    		{"Remarks21" , "30"},
    		{"Remarks22" , "30"},
    		{"Remarks23" , "30"},
    		{"Remarks24" , "30"},
    		{"CaseMarkCode" , "8"},
    		{"CaseMark1" , "30"},
    		{"CaseMark2" , "30"},
    		{"CaseMark3" , "30"},
    		{"CaseMark4" , "30"},
    		{"CaseMark5" , "30"},
    		{"CaseMark6" , "30"},
    		{"CaseMark7" , "30"},
    		{"CaseMark8" , "30"},
    		{"CaseMark9" , "30"},
    		{"CaseMark10" , "30"},
    		{"CaseMark11" , "30"},
    		{"CaseMark12" , "30"},
    		{"Attention" , "30"},
    		{"ReferenceNo" , "30"},
    		{"InvoiceIssueLocation" , "5"},
    		{"ForwarderCode" , "5"},
    		{"ETADate" , "8"},
    		{"NETWeight" , "10"},
    		{"GrossWeight" , "10"},
    		{"Volume" , "10"},
    		{"ShipperCode" , "8"},
    		{"OriginCode" , "3"},
    		{"ProductLineCode" , "3"},
    		{"ProductLineName" , "5"},
    		{"Imoh" , "16"},
    		{"Markup" , "16"},
    		{"ChargeFOB" , "14"},
    		{"ChargeOther" , "14"},
    		{"GoodsCharge" , "16"},
    		{"ToolingCharge" , "16"},
    		{"FBPurchOrderNum" , "20"},
    		{"ChargeDeptCode" , "8"},
    		{"ProjectCode" , "5"},
    		{"ChargeDeptCode2" , "8"},
    		{"ProjectCode2" , "5"},
    		{"ChargeDeptCode3" , "8"},
    		{"ProjectCode3" , "5"},
    		{"VendorSiteCode" , "10"}
        }));
        fieldConfigMap.put("0327", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"ItemIdentification" , "1"},
        	{"ItemId" , "13"},
        	{"ItemName" , "50"}
        }));
        fieldConfigMap.put("0329", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"ItemIdentification" , "1"},
        	{"ItemId" , "13"},
        	{"TransactionQty" , "5"},
        	{"TransactionDate" , "10"},
        	{"TransactionCost" , "10"},
        	{"EmployeeNo" , "10"}
        }));
        fieldConfigMap.put("0331", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
        	{"ItemCode" , "13"},
    		{"TransactionQuantity" , "7"},
    		{"TransactionDate" , "10"},
    		{"SubInventoryCode" , "5"},
    		{"InOutCode" , "2"},
    		{"OrderNo" , "9"},
    		{"AcceptUnitPrice" , "10"},
    		{"SupplierCode" , "6"},
    		{"SupplierName" , "60"},
    		{"AcceptFlg" , "1"}
        }));
        fieldConfigMap.put("0333", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"TransactionType" , "30"},
        	{"LegacyShipmentId" , "6"},
        	{"LegacyShipmentLineNum" , "2"},
        	{"ModifyType" , "1"},
        	{"TransactionDate" , "8"},
        	{"SubinventoryCode" , "5"},
        	{"TransactionQuantity" , "10"},
        	{"ItemCode" , "40"}
        }));
        fieldConfigMap.put("0334", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"ItemCode" , "13"},
        	{"TransactionQuantity" , "6"},
        	{"TransactionDate" , "10"},
        	{"SubInventoryCode" , "5"},
        	{"SPPurNo" , "10"},
        	{"TransactionCost" , "11"},
        	{"SupplierCode" , "6"},
        	{"SupplierName" , "60"},
        	{"TransactionCost" , "11"},
        	{"MERITNumber" , "13"}
        }));
        fieldConfigMap.put("0335", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"OrganizationCode" , "8"},
        	{"TransferOrganizationCode" , "3"},
        	{"WipEntityName" , "240"},
        	{"TransactionDate" , "10"},
        	{"ItemNumber" , "14"},
        	{"FmSerialNumber" , "10"},
        	{"TransactionQuantity" , "38"},
        	{"SubinventoryCode" , "5"},
        	{"TransferSubinventory" , "5"},
        	{"LocatorCode" , "40"},
        	{"TransferLocatorCode" , "40"},
        	{"TransactionUomCode" , "3"},
        	{"ProcType" , "4"},
        	{"StatusType" , "1"},
        	{"AuditNumber" , "38"},
        	{"DeliveryHeaderNumber" , "240"},
        	{"DeliveryLineNumber" , "240"},
        	{"MoveHeaderId" , "38"},
        	{"MoveLineId" , "38"},
        	{"ShipRemainderFlag" , "1"},
        	{"OrderNo" , "40"},
        	{"NotEncumberMakeKbn" , "1"},
        	{"SingleEncumberKbn" , "1"},
        	{"ShippedKbn" , "1"},
        	{"HeaderComment" , "240"},
        	{"LineComment" , "240"},
        	{"ShippingDate" , "10"},
        	{"ReceivingDate" , "10"},
        	{"UrgentFlag" , "3"},
        	{"AccountId" , "38"},
        	{"XjCode" , "5"},
        	{"SpecificationType" , "2"},
        	{"TransactionCost" , ""}
        }));
        fieldConfigMap.put("1239", new FieldConfig(FileType.VARIABLE_LENGTH, new String[][]{
        	{"SerialNumber" , "6"},
        	{"ContractNumber" , "10"},
        	{"Segment1" , "8"},
        	{"IncidentNumber" , "20"},
        	{"OrigSysDocumentRef" , "20"},
        	{"OrderedInstructions" , "60"},
        	{"ShippingInstructions" , "60"},
        	{"OrderContact" , "20"},
        	{"CustomerTelNumber" , "12"},
        	{"ShipToAddressNum" , "44"},
        	{"ShipToBuilding" , "40"},
        	{"ShipToFloor" , "6"},
        	{"ShipToAddress" , "100"},
        	{"ShipToName" , "40"},
        	{"ShipToDivision" , "40"},
        	{"RequestDate" , "10"},
        	{"ItemIdNN" , "14"},
        	{"SalesQtyNN" , "7"}
        }));
        fieldConfigMap.put("2704", new FieldConfig(FileType.FIXED_LENGTH, new String[][]{
        	{"ContractNumber" , "10"},
    		{"DeliveryScheduledDate" , "8"},
    		{"AutoReplenishmentNumber" , "7"},
    		{"OrderSourceName" , "2"},
    		{"SpecifiedTime" , "9"},
    		{"UrgentFlag" , "1"},
    		{"CollectionFlag" , "1"},
    		{"NextVisitDate" , "8"},
    		{"SalesResponsibleName" , "20"},
    		{"BuildingName" , "34"},
    		{"ShipToFloor" , "6"},
    		{"ShipToDivision" , "40"},
    		{"OrdererName" , "20"},
    		{"DeliveryToNotes" , "60"},
    		{"SalesOrderNotes" , "60"},
    		{"NumberOfLines" , "2"},
    		{"ItemCode01" , "14"},
    		{"Quantity01" , "7"},
    		{"ItemCode02" , "14"},
    		{"Quantity02" , "7"},
    		{"ItemCode03" , "14"},
    		{"Quantity03" , "7"},
    		{"ItemCode04" , "14"},
    		{"Quantity04" , "7"},
    		{"ItemCode05" , "14"},
    		{"Quantity05" , "7"},
    		{"ItemCode06" , "14"},
    		{"Quantity06" , "7"},
    		{"ItemCode07" , "14"},
    		{"Quantity07" , "7"},
    		{"ItemCode08" , "14"},
    		{"Quantity08" , "7"},
    		{"ItemCode09" , "14"},
    		{"Quantity09" , "7"},
    		{"ItemCode10" , "14"},
    		{"Quantity10" , "7"},
    		{"ItemCode11" , "14"},
    		{"Quantity11" , "7"},
    		{"ItemCode12" , "14"},
    		{"Quantity12" , "7"},
    		{"ItemCode13" , "14"},
    		{"Quantity13" , "7"},
    		{"ItemCode14" , "14"},
    		{"Quantity14" , "7"},
    		{"ItemCode15" , "14"},
    		{"Quantity15" , "7"}
        }));

        // 遍历输入目录的文件
        File folder = new File(inputFolder);
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("输入目录中没有文件。");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                String outputFile = outputFolder + fileName + ".csv";

                // 加载字段配置
                FieldConfig config = fieldConfigMap.get(fileName);
                if (config == null) {
                    System.out.println("未找到字段配置，跳过文件：" + fileName);
                    continue;
                }

                try {
                    if (config.getFileType() == FileType.FIXED_LENGTH) {
                        System.out.println("处理固定长度文件：" + fileName);
                        processFixedLengthFile(file, outputFile, config.getFieldDefinitions());
                    } else if (config.getFileType() == FileType.VARIABLE_LENGTH) {
                        System.out.println("处理可变长度文件：" + fileName);
                        processVariableLengthFile(file, outputFile, config.getFieldDefinitions());
                    }
                } catch (Exception e) {
                    System.err.println("处理文件出错：" + fileName + "，错误原因：" + e.getMessage());
                }
            }
        }
    }

    /**
     * 处理固定长度文件，并检查空值，返回空值字段
     */
    public static void processFixedLengthFile(File inputFile, String outputFile, String[][] fieldDefinitions) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // 写入 CSV 表头
            List<String> headers = new ArrayList<>();
            for (String[] field : fieldDefinitions) {
                headers.add(field[0]);
            }
            headers.add("Empty_Check"); // 增加空值检查列
            writer.write(String.join(",", headers));
            writer.newLine();

            // 逐行解析并写入
            String line;
            while ((line = reader.readLine()) != null) {
                List<String> values = new ArrayList<>();
                List<String> emptyFields = new ArrayList<>();  // 用于保存空字段的名称
                int start = 0;

                for (String[] field : fieldDefinitions) {
                    int length = Integer.parseInt(field[1]);
                    String value = line.substring(start, Math.min(start + length, line.length())).trim();
                    values.add(value);
                    start += length;

                    // 如果字段为空，记录字段名称
                    if (value.isEmpty()) {
                        emptyFields.add(field[0]);
                    }
                }

                // 在最后一列添加空值字段信息
                if (!emptyFields.isEmpty()) {
                    values.add(String.join(";", emptyFields)); // 如果有空字段，列出空字段名称
                } else {
                    values.add("No Empty Fields");
                }

                writer.write(String.join(",", values));
                writer.newLine();
            }
        }
    }

    /**
     * 处理可变长度文件，并检查空值，返回空值字段
     */
    public static void processVariableLengthFile(File inputFile, String outputFile, String[][] fieldDefinitions) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // 写入 CSV 表头
            List<String> headers = new ArrayList<>();
            for (String[] field : fieldDefinitions) {
                headers.add(field[0]);
            }
            headers.add("Empty_Check");  // 添加空值检查字段
            writer.write(String.join(",", headers));
            writer.newLine();

            // 逐行解析并写入
            String line;

            while ((line = reader.readLine()) != null) {
            	
            	String delimiter = line.contains("|") ? "\\|" : ",";
            	String[] fields = line.split(delimiter);// 根据分隔符进行切割
            	

                List<String> fieldList = new ArrayList<>();
                List<String> emptyFields = new ArrayList<>();  // 用于保存空字段的名称

                // 遍历字段，检查是否为空
                for (int i = 0; i < fields.length; i++) {
                    String field = fields[i].trim();
                    fieldList.add(field);

                    if (field.isEmpty()) {
                        // 获取字段名称，如果为空字段，记录其名称
                        emptyFields.add(fieldDefinitions[i][0]);
                    }
                }

                // 如果有空字段，则在行末尾加上空字段信息
                if (!emptyFields.isEmpty()) {
                    fieldList.add(String.join(";", emptyFields)); // 列出所有空字段
                } else {
                    fieldList.add("No Empty Fields");
                }

                writer.write(String.join(",", fieldList));
                writer.newLine();
            }
        }
    }

    /**
     * 文件类型枚举
     */
    enum FileType {
        FIXED_LENGTH,
        VARIABLE_LENGTH
    }

    /**
     * 字段配置类
     */
    static class FieldConfig {
        private final FileType fileType;
        private final String[][] fieldDefinitions;

        public FieldConfig(FileType fileType, String[][] fieldDefinitions) {
            this.fileType = fileType;
            this.fieldDefinitions = fieldDefinitions;
        }

        public FileType getFileType() {
            return fileType;
        }

        public String[][] getFieldDefinitions() {
            return fieldDefinitions;
        }
        
    }
    
}
