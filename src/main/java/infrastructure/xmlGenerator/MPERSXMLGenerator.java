package infrastructure.xmlGenerator;


import org.w3c.dom.Document;

public class MPERSXMLGenerator extends XMLGenerator{
    private final String _ee_mpers = "-ee-mpers:";

    @Override
    public void generateXML() {
        String fromDate = "20160801";
        String toDate = "20170731";
        final String fromTo = "fromto_" + fromDate + "_" + toDate;
        final String contextRef = "contextRef";
        final String asofToDate = "asof_" + toDate;
        Document document = new NodeGenerator(createDocument())
                .createRoot()
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.CompanyRegistrationNumber, fromTo, "abcCompany")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.NameOfReportingEntity, fromTo, "Unique Blend Sdn. Bhd.")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.FormerNameOfCompany, fromTo, "NUTRICOMPASS SDN BHD")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.OriginOfCompany, fromTo, "Incorporated in Malaysia")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.StatusOfCompany, fromTo, "Private company")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.TypeOfCompany, fromTo, "Company limited by shares")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.DisclosureOfFinancialStatementsPreparationForCurrentSubmission, fromTo, "Subsequent preparation of financial statements")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.CompanyCurrentFinancialYearStartDate, asofToDate, "2016-08-01")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.CompanyCurrentFinancialYearEndDate, asofToDate, "2017-07-31")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.CompanyPreviousFinancialYearStartDate, asofToDate, "2015-08-01")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.CompanyPreviousFinancialYearEndDate, asofToDate, "2016-07-31")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.StatusOfCarryingOnBusinessDuringFinancialYear, fromTo, "Carrying on business activities")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.DisclosureOfFinancialStatementsAuditStatus, fromTo, "Audited")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.BasisOfAccountingStandardsAppliedToPrepareFinancialStatements, fromTo, "Malaysian Financial Reporting Standards")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.TypeOfSubmission, fromTo, "FS-MFRS")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + _ee_mpers + Part2NodeTag.NatureOfFinancialStatements, fromTo, "ifrs-full:SeparateMember")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.DescriptionOfPresentationCurrency, fromTo, "Malaysian Ringgit (MYR)")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.DescriptionOfFunctionalCurrency, fromTo, "MYR")
                .createElementWithContextRef(CommonNodeTag.ssmt_dei + Part2NodeTag.LevelOfRoundingUsedInFinancialStatements, fromTo, "Actuals")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DateOfFinancialStatementsApprovedByBoardOfDirectors, asofToDate, "2017-10-25")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DateOfCirculationOfFinancialStatementsAndReportsToMembers, asofToDate, "2017-10-25")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DateOfStatutoryDeclaration, asofToDate, "2017-10-25")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOnWhetherCompanysSharesAreTradedOnAnyOfficialStockExchange, fromTo, "Not-listed")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfWhetherCompanyRegulatedByBankNegaraMalaysiaAtFinancialYearEnd, fromTo, "Company not regulated by Bank Negara Malaysia")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.MSICCode, fromTo + "_BusinessOneMember", "24109u")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DescriptionOfBusiness, fromTo + "_BusinessOneMember", "EXPORT AND IMPORT  OF OTHER BASIC IRON AND STEEL PRODUCTS N.E.C.")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.MSICCode, fromTo + "_BusinessTwoMember", "46639u")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DescriptionOfBusiness, fromTo + "_BusinessTwoMember", "EXPORT AND IMPORT OF OTHER CONSTRUCTION MATERIALS, HARDWARE, PLUMBING AND HEATING EQUIPMENT AND SUPPLIES N.E.C.")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DescriptionOnWhetherCompanyHadAppliedForAnyExemptionWaiverReliefOrExtensionOfTimeWithRegardToAnnualReturnOrFinancialStatementsAndReportsFromRegistrarOrMinister, fromTo, "No")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.MethodUsedForPreparingStatementOfFinancialPosition, fromTo, "Current-Noncurrent")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.MethodUsedForPreparingStatementOfProfitOrLoss, fromTo, "Function of expense")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.MethodUsedForPreparingStatementOfComprehensiveIncome, fromTo, "After tax")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.MethodUsedForPreparingStatementOfCashFlows, fromTo, "Indirect")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOnWhetherComparativePeriodValuesAreRestated, fromTo, "No")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOnWhetherOpeningStatementChangedDueToChangesInAccountingStandards, fromTo, "No")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOnWhetherReclassificationOfPreviousFinancialStatementsChangedDueToChangesInAccountingStandards, fromTo, "No")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOnWhetherCompanyChangedDurationOfFinancialReportingPeriod, fromTo, "No")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfDirectorsReportExplanatory, fromTo, "html")

                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.NumberOfDirectorsSigningDirectorsReport, fromTo, "2")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.NameOfFirstDirectorWhoSignedDirectorsReport, fromTo, "Director 1")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.TypeOfIdentificationOfFirstDirectorWhoSignedDirectorsReport, fromTo, "MyKad")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.IdentificationNumberOfFirstDirectorWhoSignedDirectorsReport, fromTo, "111111111111")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.NameOfSecondDirectorWhoSignedDirectorsReport, fromTo, "Director 2")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.TypeOfIdentificationOfSecondDirectorWhoSignedDirectorsReport, fromTo, "MyKad")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.IdentificationNumberOfSecondDirectorWhoSignedDirectorsReport, fromTo, "222222222222")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfStatusOfDividend, fromTo, "Not mentioned")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfContingentOrOtherLiabilityBeingEnforceableWithinTwelveMonthsAfterEndOfFinancialYear, fromTo, "No")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfOccurenceOfAnySubstantialMaterialOrUnusualInNatureItemsTransactionsOrEvents, fromTo, "No")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfDirectorsReceivedOrBecomeEntitledToReceiveOtherBenefitsByReasonOfContractMadeByCompanyOrRelatedCorporation, fromTo, "No")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DateOfSigningDirectorsReport, asofToDate, "2018-05-31")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfStatementByDirectorsExplanatory, fromTo, "html")

                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfDirectorsOpinionThatFinancialStatementsOrConsolidatedFinancialStatementsAreDrawnInAccordanceWithAccountingStandards, fromTo, "Yes")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.NumberOfDirectorsSigningStatementByDirectors, fromTo, "2")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.NameOfFirstDirectorWhoSignedStatementByDirectors, fromTo, "Director 1")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureWhetherFirstDirectorIsAlsoPrimarilyResponsibleForFinancialManagementOfCompany, fromTo, "Primarily responsible for financial management of the company")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.TypeOfIdentificationOfFirstDirectorWhoSignedStatementByDirectors, fromTo, "MyKad")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.IdentificationNumberOfFirstDirectorWhoSignedStatementByDirectors, fromTo, "111111111111")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.NameOfSecondDirectorWhoSignedStatementByDirectors, fromTo, "Director 2")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureWhetherSecondDirectorIsAlsoPrimarilyResponsibleForFinancialManagementOfCompany, fromTo, "Not primarily responsible for financial management of the company")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.TypeOfIdentificationNumberOfSecondDirectorWhoSignedStatementByDirectors, fromTo, "MyKad")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.IdentificationNumberOfSecondDirectorWhoSignedStatementByDirectors, fromTo, "222222222222")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.NameOfOtherPersonPrimarilyResponsibleForFinancialStatementsOfCompany, fromTo, "Director 1")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.TypeOfIdentificationOfOtherPersonPrimarilyResponsibleForFinancialStatementsOfCompany, fromTo, "MyKad")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.IdentificationNumberOfOtherPersonPrimarilyResponsibleForFinancialManagementOfCompany, fromTo, "111111111111")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DateOfSigningStatementByDirectors, asofToDate, "2018-05-31")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfStatementByDirectorsForBusinessReviewExplanatory, fromTo, "html")

                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfBusinessReviewEitherOnEnvironmentEmployeesOrSocialAndCommunityIssues, fromTo, "Company's employees")
                .createElementWithUnitRefDecimal(CommonNodeTag.ssmt + Part2NodeTag.NumberOfEmployees, fromTo, "PURE", "INF", "2")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DisclosureOfAuditorsReportToMembersExplanatory, fromTo, "html")

                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.TypeOfAuditorsOpinion, fromTo, "Unmodified opinion")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.DateOfSigningAuditorsReport, asofToDate, "2018-05-31")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.LicenseNumberOfAuditor, fromTo, "1234")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.RegistrationNumberOfAuditFirm, fromTo, "AF0750")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.NameOfAuditFirm, fromTo, "KS")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.AddressOne, fromTo, "14-2, Jalan 4A/27A")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.AddressTwo, fromTo, "Section 2")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.AddressThree, fromTo, "Wangsa Maju")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.PostcodeOfAuditFirm, fromTo, "53300")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.TownWhereAuditFirmIsLocated, fromTo, "KUALA LUMPUR")
                .createElementWithContextRef(CommonNodeTag.ssmt + Part2NodeTag.StateWhereAuditFirmIsLocated, fromTo, "W.P. KUALA LUMPUR")
                .build();

        createXMLFile(document);
    }
}
