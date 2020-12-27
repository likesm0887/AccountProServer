package XMLGenerator;


import org.w3c.dom.Document;

public class MPERSXMLGenerator extends XMLGenerator{

    @Override
    public void generateXML() {
        String fromDate = "20160801";
        String toDate = "20170731";
        final String fromTo = "fromto_" + fromDate + "_" + toDate;
        final String contextRef = "contextRef";
        final String asofToDate = "asof_" + toDate;
        Document document = new NodeGenerator(createDocument())
                .createRoot()
                .createElementWithAttribute(NodeTag.CompanyRegistrationNumber, contextRef, fromTo, "abcCompany")
                .createElementWithAttribute(NodeTag.NameOfReportingEntity, contextRef, fromTo, "Unique Blend Sdn. Bhd.")
                .createElementWithAttribute(NodeTag.FormerNameOfCompany, contextRef, fromTo, "NUTRICOMPASS SDN BHD")
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
                .createElementWithAttribute(NodeTag.NatureOfFinancialStatements_MPERS, contextRef, fromTo, "ifrs-full:SeparateMember")
                .createElementWithAttribute(NodeTag.DescriptionOfPresentationCurrency, contextRef, fromTo, "Malaysian Ringgit (MYR)")
                .createElementWithAttribute(NodeTag.DescriptionOfFunctionalCurrency, contextRef, fromTo, "MYR")
                .createElementWithAttribute(NodeTag.LevelOfRoundingUsedInFinancialStatements, contextRef, fromTo, "Actuals")
                .createElementWithAttribute(NodeTag.DateOfFinancialStatementsApprovedByBoardOfDirectors, contextRef, asofToDate, "2017-10-25")
                .createElementWithAttribute(NodeTag.DateOfCirculationOfFinancialStatementsAndReportsToMembers, contextRef, asofToDate, "2017-10-25")
//                .createElementWithAttribute(NodeTag.DateOfFinancialStatementsAndReportsOfDirectorsAndAuditorsLaidInAnnualGeneralMeeting, contextRef, asofToDate, "2017-11-30")
                .createElementWithAttribute(NodeTag.DateOfStatutoryDeclaration, contextRef, asofToDate, "2017-10-25")
                .createElementWithAttribute(NodeTag.DisclosureOnWhetherCompanysSharesAreTradedOnAnyOfficialStockExchange, contextRef, fromTo, "Not-listed")
//                .createElementWithAttribute(NodeTag.DisclosureOfRegulationAppliedDuringIncorporationOfCompany, contextRef, fromTo, "Companies Act 1965 or 2016")
                .createElementWithAttribute(NodeTag.DisclosureOfWhetherCompanyRegulatedByBankNegaraMalaysiaAtFinancialYearEnd, contextRef, fromTo, "Company not regulated by Bank Negara Malaysia")
                .createElementWithAttribute(NodeTag.MSICCode, contextRef, fromTo + "_BusinessOneMember", "24109u")
                .createElementWithAttribute(NodeTag.DescriptionOfBusiness, contextRef, fromTo + "_BusinessOneMember", "EXPORT AND IMPORT  OF OTHER BASIC IRON AND STEEL PRODUCTS N.E.C.")
                .createElementWithAttribute(NodeTag.MSICCode, contextRef, fromTo + "_BusinessTwoMember", "46639u")
                .createElementWithAttribute(NodeTag.DescriptionOfBusiness, contextRef, fromTo + "_BusinessTwoMember", "EXPORT AND IMPORT OF OTHER CONSTRUCTION MATERIALS, HARDWARE, PLUMBING AND HEATING EQUIPMENT AND SUPPLIES N.E.C.")
                .createElementWithAttribute(NodeTag.DescriptionOnWhetherCompanyHadAppliedForAnyExemptionWaiverReliefOrExtensionOfTimeWithRegardToAnnualReturnOrFinancialStatementsAndReportsFromRegistrarOrMinister, contextRef, fromTo, "No")
                .createElementWithAttribute(NodeTag.MethodUsedForPreparingStatementOfFinancialPosition, contextRef, fromTo, "Current-Noncurrent")
                .createElementWithAttribute(NodeTag.MethodUsedForPreparingStatementOfProfitOrLoss, contextRef, fromTo, "Function of expense")
                .createElementWithAttribute(NodeTag.MethodUsedForPreparingStatementOfComprehensiveIncome, contextRef, fromTo, "After tax")
                .createElementWithAttribute(NodeTag.MethodUsedForPreparingStatementOfCashFlows, contextRef, fromTo, "Indirect")
                .createElementWithAttribute(NodeTag.DisclosureOnWhetherComparativePeriodValuesAreRestated, contextRef, fromTo, "No")
                .createElementWithAttribute(NodeTag.DisclosureOnWhetherOpeningStatementChangedDueToChangesInAccountingStandards, contextRef, fromTo, "No")
                .createElementWithAttribute(NodeTag.DisclosureOnWhetherReclassificationOfPreviousFinancialStatementsChangedDueToChangesInAccountingStandards, contextRef, fromTo, "No")
                .createElementWithAttribute(NodeTag.DisclosureOnWhetherCompanyChangedDurationOfFinancialReportingPeriod, contextRef, fromTo, "No")
                .createElementWithAttribute(NodeTag.DisclosureOfDirectorsReportExplanatory, contextRef, fromTo, "html")

                .build();

        createXMLFile(document);
    }
}
