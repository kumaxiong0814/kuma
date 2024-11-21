package com.a;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FixedLengthToCSVApp {

    public static void main(String[] args) {
    	Map<String,String[][]> fileConfigurations = new HashMap<>();
    	
        // 文件 275 的字段配置
    	fileConfigurations.put("0275",new String[][]{
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
        });
        // 文件 281 的字段配置
    	fileConfigurations.put("0281",new String[][]{
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

        });
        // 文件 288 的字段配置
    	fileConfigurations.put("0288",new String[][]{
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

        });
        // 文件 290 的字段配置
    	fileConfigurations.put("0290",new String[][]{
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

        });
        // 文件 292 的字段配置
    	fileConfigurations.put("0292",new String[][]{
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

        });
        // 文件 295 的字段配置
    	fileConfigurations.put("0295",new String[][]{
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
        });
        // 文件 312 的字段配置
    	fileConfigurations.put("0312",new String[][]{
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

        });
        // 文件 313 的字段配置
    	fileConfigurations.put("0313",new String[][]{
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

        });

        // 文件 331 的字段配置
    	fileConfigurations.put("0331",new String[][]{
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
        });

        // 文件 2704 的字段配置
    	fileConfigurations.put("2704",new String[][]{
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

        });
      
    String inputFolder = "C:\\Users\\e-ls-dev-315\\Desktop\\Test\\input\\" ;
    String outputFolder = "C:\\Users\\e-ls-dev-315\\Desktop\\Test\\output\\" ;
    
    // 确保输出目录存在
    File outputDir = new File(outputFolder);
    if (!outputDir.exists()) {
        if (outputDir.mkdirs()) {
            System.out.println("输出文件夹已创建：" + outputFolder);
        } else {
            System.err.println("输出文件夹创建失败，请检查路径：" + outputFolder);
            return;
        }
    }

    // 扫描输入目录下的所有文件
    File folder = new File(inputFolder);
    File[] files = folder.listFiles();

    if (files == null || files.length == 0) {
        System.out.println("输入目录中没有文件。");
        return;
    }

    // 批量处理文件
    for (File file : files) {
        if (file.isFile()) {
            String fileName = file.getName();
            if (fileConfigurations.containsKey(fileName)) {
                String[][] fieldConfig = fileConfigurations.get(fileName);
                String inputFile = file.getAbsolutePath();
                String outputFile = outputFolder + fileName + ".csv";

                try {
                    FixedLengthFileProcessor.convertToCSV(fieldConfig, inputFile, outputFile);
                    System.out.println("成功转换文件：" + inputFile + " -> " + outputFile);
                } catch (Exception e) {
                    System.err.println("处理文件出错：" + inputFile + "，错误原因：" + e.getMessage());
                }
            } else {
                System.out.println("文件未配置字段定义，跳过：" + fileName);
            }
        }
    }
}
}
