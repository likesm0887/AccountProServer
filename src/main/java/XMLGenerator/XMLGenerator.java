package XMLGenerator;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLGenerator {

    public void generateXML() throws ParserConfigurationException, TransformerException {
        String fromDate = "20160801";
        String toDate = "20170731";
        String fromTo = "fromto_" + fromDate + "_" + toDate;
        final String contextRef = "contextRef";
        String asofToDate = "asof_" + toDate;
        Document document = new NodeGenerator(createDocument())
                .createRoot()
                .createElementWithAttribute("ssmt-dei:CompanyRegistrationNumber", contextRef, fromTo, "abcCompany")
                .createElementWithAttribute("ssmt-dei:NameOfReportingEntity", contextRef, fromTo, "Unique Blend Sdn. Bhd.")
                .createElementWithAttribute("ssmt-dei:OriginOfCompany", contextRef, fromTo, "Incorporated in Malaysia")
                .createElementWithAttribute("ssmt-dei:StatusOfCompany", contextRef, fromTo, "Private company")
                .createElementWithAttribute("ssmt-dei:TypeOfCompany", contextRef, fromTo, "Company limited by shares")
                .createElementWithAttribute("ssmt-dei:DisclosureOfFinancialStatementsPreparationForCurrentSubmission", contextRef, fromTo, "Subsequent preparation of financial statements")
                .createElementWithAttribute("ssmt-dei:CompanyCurrentFinancialYearStartDate", contextRef, asofToDate, "2016-08-01")
                .createElementWithAttribute("ssmt-dei:CompanyCurrentFinancialYearEndDate", contextRef, asofToDate, "2017-07-31")
                .createElementWithAttribute("ssmt-dei:CompanyPreviousFinancialYearStartDate", contextRef, asofToDate, "2015-08-01")
                .createElementWithAttribute("ssmt-dei:CompanyPreviousFinancialYearEndDate", contextRef, asofToDate, "2016-07-31")
                .createElementWithAttribute("ssmt-dei:StatusOfCarryingOnBusinessDuringFinancialYear", contextRef, fromTo, "Carrying on business activities")
                .createElementWithAttribute("ssmt-dei:DisclosureOfFinancialStatementsAuditStatus", contextRef, fromTo, "Audited")
                .createElementWithAttribute("ssmt-dei:BasisOfAccountingStandardsAppliedToPrepareFinancialStatements", contextRef, fromTo, "Malaysian Financial Reporting Standards")
                .createElementWithAttribute("ssmt-dei:TypeOfSubmission", "contextRef", fromTo, "FS-MFRS")
                .createElementWithAttribute("ssmt-dei-ee-mfrs:NatureOfFinancialStatements", contextRef, fromTo, "ifrs-full:SeparateMember")
                .createElementWithAttribute("ssmt-dei:DescriptionOfPresentationCurrency", contextRef, fromTo, "Malaysian Ringgit (MYR)")
                .createElementWithAttribute("ssmt-dei:DescriptionOfFunctionalCurrency", contextRef, fromTo, "MYR")
                .createElementWithAttribute("ssmt-dei:LevelOfRoundingUsedInFinancialStatements", contextRef, fromTo, "Actuals")
                .createElementWithAttribute("ssmt:DateOfFinancialStatementsApprovedByBoardOfDirectors", contextRef, asofToDate, "2017-10-25")
                .createElementWithAttribute("ssmt:DateOfCirculationOfFinancialStatementsAndReportsToMembers", contextRef, asofToDate, "2017-10-25")
                .createElementWithAttribute("ssmt:DateOfFinancialStatementsAndReportsOfDirectorsAndAuditorsLaidInAnnualGeneralMeeting", contextRef, asofToDate, "2017-11-30")
                .createElementWithAttribute("ssmt:DateOfStatutoryDeclaration", contextRef, asofToDate, "2017-10-25")
                .createElementWithAttribute("ssmt:DisclosureOnWhetherCompanysSharesAreTradedOnAnyOfficialStockExchange", contextRef, fromTo, "Not-listed")
                .createElementWithAttribute("ssmt:DisclosureOfRegulationAppliedDuringIncorporationOfCompany", contextRef, fromTo, "Companies Act 1965 or 2016")
                .createElementWithAttribute("ssmt:DisclosureOfWhetherCompanyRegulatedByBankNegaraMalaysiaAtFinancialYearEnd", contextRef, fromTo, "Company not regulated by Bank Negara Malaysia")
                .createElementWithAttribute("ssmt:MSICCode", contextRef, fromTo + "_BusinessOneMember", "24109u")
                .createElementWithAttribute("ssmt:DescriptionOfBusiness", contextRef, fromTo + "_BusinessOneMember", "EXPORT AND IMPORT  OF OTHER BASIC IRON AND STEEL PRODUCTS N.E.C.")
                .createElementWithAttribute("ssmt:MSICCode", contextRef, fromTo + "_BusinessTwoMember", "46639u")
                .createElementWithAttribute("ssmt:DescriptionOfBusiness", contextRef, fromTo + "_BusinessTwoMember", "EXPORT AND IMPORT OF OTHER CONSTRUCTION MATERIALS, HARDWARE, PLUMBING AND HEATING EQUIPMENT AND SUPPLIES N.E.C.")
                .createElementWithAttribute("ssmt:DescriptionOnWhetherCompanyHadAppliedForAnyExemptionWaiverReliefOrExtensionOfTimeWithRegardToAnnualReturnOrFinancialStatementsAndReportsFromRegistrarOrMinister", contextRef, fromTo, "No")
                .createElementWithAttribute("ssmt:MethodUsedForPreparingStatementOfFinancialPosition", contextRef, fromTo, "Current-Noncurrent")
                .createElementWithAttribute("ssmt:MethodUsedForPreparingStatementOfProfitOrLoss", contextRef, fromTo, "Function of expense")
                .createElementWithAttribute("ssmt:MethodUsedForPreparingStatementOfComprehensiveIncome", contextRef, fromTo, "After tax")
                .createElementWithAttribute("ssmt:MethodUsedForPreparingStatementOfCashFlows", contextRef, fromTo, "Indirect")
                .createElementWithAttribute("ssmt:DisclosureOnWhetherComparativePeriodValuesAreRestated", contextRef, fromTo, "No")
                .createElementWithAttribute("ssmt:DisclosureOnWhetherOpeningStatementChangedDueToChangesInAccountingStandards", contextRef, fromTo, "No")
                .createElementWithAttribute("ssmt:DisclosureOnWhetherReclassificationOfPreviousFinancialStatementsChangedDueToChangesInAccountingStandards", contextRef, fromTo, "No")
                .createElementWithAttribute("ssmt:DisclosureOnWhetherCompanyChangedDurationOfFinancialReportingPeriod", contextRef, fromTo, "No")
                .createElementWithAttribute("ssmt:DisclosureOfDirectorsReportExplanatory", contextRef, fromTo, "")
                .build();

        createXMLFile(document);
    }

    private Document createDocument() throws ParserConfigurationException {
        return DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .newDocument();
    }

    private void createXMLFile(Document document) throws TransformerException {
        Transformer transformer = createTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("/Users/jammytan/Documents/Account/test.xml"));
        transformer.transform(domSource, streamResult);
    }

    private Transformer createTransformer() throws TransformerConfigurationException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        return transformer;
    }

}
