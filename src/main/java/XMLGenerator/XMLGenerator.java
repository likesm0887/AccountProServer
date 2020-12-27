package XMLGenerator;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLGenerator {
    public static void main(String[] args) {

        try {
            generateXML();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    public static void generateXML() throws TransformerException {
        String fromDate = "20160801";
        String toDate = "20170731";
        String fromTo = "fromto_" + fromDate + "_" + toDate;
        final String contextRef = "contextRef";
        String asofToDate = "asof_" + toDate;
        Document document = new NodeGenerator(createDocument())
                .createRoot()
                .createElementWithAttribute(NodeTag.CompanyRegistrationNumber, contextRef, fromTo, "abcCompany")
                .createElementWithAttribute(NodeTag.NameOfReportingEntity, contextRef, fromTo, "Unique Blend Sdn. Bhd.")
                .createElementWithAttribute(NodeTag.OriginOfCompany, contextRef, fromTo, "Incorporated in Malaysia")
                .createElementWithAttribute(NodeTag.StatusOfCompany, contextRef, fromTo, "Private company")
                .createElementWithAttribute(NodeTag.TypeOfCompany, contextRef, fromTo, "Company limited by shares")
                .createElementWithAttribute(NodeTag.DisclosureOfFinancialStatementsPreparationForCurrentSubmission, contextRef, fromTo, "Subsequent preparation of financial statements")
                .createElementWithAttribute(NodeTag.CompanyCurrentFinancialYearStartDate, contextRef, asofToDate, "2016-08-01")
                .createElementWithAttribute(NodeTag.CompanyCurrentFinancialYearEndDate, contextRef, asofToDate, "2017-07-31")
                .createElementWithAttribute(NodeTag.CompanyPreviousFinancialYearStartDate, contextRef, asofToDate, "2015-08-01")
                .createElementWithAttribute(NodeTag.CompanyPreviousFinancialYearEndDate, contextRef, asofToDate, "2016-07-31")
                .createElementWithAttribute(NodeTag.StatusOfCarryingOnBusinessDuringFinancialYear, contextRef, fromTo, "Carrying on business activities")
                .createElementWithAttribute(NodeTag.DisclosureOfFinancialStatementsAuditStatus, contextRef, fromTo, "Audited")
                .createElementWithAttribute(NodeTag.BasisOfAccountingStandardsAppliedToPrepareFinancialStatements, contextRef, fromTo, "Malaysian Financial Reporting Standards")
                .createElementWithAttribute(NodeTag.TypeOfSubmission, contextRef, fromTo, "FS-MFRS")
                .createElementWithAttribute(NodeTag.NatureOfFinancialStatements, contextRef, fromTo, "ifrs-full:SeparateMember")
                .createElementWithAttribute(NodeTag.DescriptionOfPresentationCurrency, contextRef, fromTo, "Malaysian Ringgit (MYR)")
                .createElementWithAttribute(NodeTag.DescriptionOfFunctionalCurrency, contextRef, fromTo, "MYR")
                .createElementWithAttribute(NodeTag.LevelOfRoundingUsedInFinancialStatements, contextRef, fromTo, "Actuals")
                .createElementWithAttribute(NodeTag.DateOfFinancialStatementsApprovedByBoardOfDirectors, contextRef, asofToDate, "2017-10-25")
                .createElementWithAttribute(NodeTag.DateOfCirculationOfFinancialStatementsAndReportsToMembers, contextRef, asofToDate, "2017-10-25")
                .createElementWithAttribute(NodeTag.DateOfFinancialStatementsAndReportsOfDirectorsAndAuditorsLaidInAnnualGeneralMeeting, contextRef, asofToDate, "2017-11-30")
                .createElementWithAttribute(NodeTag.DateOfStatutoryDeclaration, contextRef, asofToDate, "2017-10-25")
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

    private static Document createDocument()  {
        try {
            return DocumentBuilderFactory
                    .newInstance()
                    .newDocumentBuilder()
                    .newDocument();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Create document failed");
        }

    }

    private static void createXMLFile(Document document) throws TransformerException {
        Transformer transformer = createTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("./output/test.xml"));
        transformer.transform(domSource, streamResult);
    }

    private static Transformer createTransformer() throws TransformerConfigurationException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        return transformer;
    }

}
