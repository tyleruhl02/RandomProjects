package HighSchool.Other;

import java.util.Arrays;

public class test6 {
    public static void main(String[] args) {
        String[] s1 = "ABB ACW AEO ADF ADV AJH BGQ ABC AQX AVO ABD ACO ANC ABE ABR AEV AFC AJB ADO AEW AHU AGF AHV AJD ABF AIF ABH ABL ACR AOM AEP ANA ABM AJQ ABN ABS ABZ ACK ACS ADE AFS AHN AIC ANI AIG AKM ABO ABP AJW ABV ABW ABX ADK AHW AMH ABY ACA AGW AKV ACB ACC ACD ACT ACE AER ACI AIX ACM ACP ANV ACV ACY AIN ADD ADG ADH AIL ADI AKW ADJ ADQ AFU ADS ALR ADT AEX ADX ADY AEA AEB AEE AEH AEJ APV AEK AEM AEN AQC AET AEU AFB AGT AFD AIA AFE AFP AGE AFW AMF AGG AGL AHE AHF AHH AHZ AIB AID AIE AQJ AIV AJC AJE AJG AJL AJM AJV AKP AKQ ALV ANW AOI APS ARY".split(" ");
        String[] s2 = "ABZ ACK ACS ADE AEW AHU AFS AHN AIC ANI AIG AKM ABB ACW AEO ADF ADV AJH BGQ ABC AQX AVO ABD ACO ANC ABE ABR AEV AFC AJB ADO AGF AHV AJD ABF AIF ABH ABL ACR AOM AEP ANA ABM AJQ ABN ABS ABO ABP AJW ABV ABW ABX ADK AHW AMH ABY ACA AGW AKV ACB ACC ACD ACT ACE AER ACI AIX ACM ACP ANV ACV ACY AIN ADD ADG ADH AIL ADI AKW ADJ ADQ AFU ADS ALR ADT AEX ADX ADY AEA AEB AEE AEH AEJ APV AEK AEM AEN AQC AET AEU AFB AGT AFD AIA AFE AFP AGE AFW AMF AGG AGL AHZ AHE AHF AHH AIB AID AIE AQJ AIV AJC AJE AJG AJL AJM AJV AKP AKQ ALV ANW AOI APS ARY".split(" ");
       /* String frag1 = "ABB ACW AEO ADF ADV AJH BGQ ABC AQX AVO ABD ACO ANC ABE ABR AEV AFC AJB ADO ";
        String frag2 = "AGF AHV AJD ABF AIF ABH ABL ACR AOM AEP ANA ABM AJQ ABN ABS ";
        String frag3 = "ABO ABP AJW ABV ABW ABX ADK AHW AMH ABY ACA AGW AKV ACB ACC ACD ACT ACE AER ACI AIX ACM ACP ANV ACV ACY AIN ADD ADG ADH AIL ADI AKW ADJ ADQ AFU ADS ALR ADT AEX ADX ADY AEA AEB AEE AEH AEJ APV AEK AEM AEN AQC AET AEU AFB AGT AFD AIA AFE AFP AGE AFW AMF AGG AGL ";
        String frag4 = "AIB AID AIE AQJ AIV AJC AJE AJG AJL AJM AJV AKP AKQ ALV ANW AOI APS ARY";
        s1 = s1.replace(frag1, "111 ").replace(frag2, "222 ").replace(frag3, "333 ").replace(frag4, "444");
        s2 = s2.replace(frag1, "111 ").replace(frag2, "222 ").replace(frag3, "333 ").replace(frag4, "444");
        System.out.println(s1);
        System.out.println(s2);*/
        /*String[] s1 = ("AAD\n" +
                "AAE\n" +
                "AAF\n" +
                "AAG\n" +
                "AAH\n" +
                "AAI\n" +
                "AAJ\n" +
                "AAK\n" +
                "AAL\n" +
                "AAM\n" +
                "AAN\n" +
                "AAO\n" +
                "AAP\n" +
                "AAQ\n" +
                "AAR\n" +
                "AAS\n" +
                "AAT\n" +
                "AAU\n" +
                "AAV\n" +
                "AAW\n" +
                "AAX\n" +
                "AAY\n" +
                "ABZ\n" +
                "ABA\n" +
                "ABB\n" +
                "ABC\n" +
                "ABD\n" +
                "ABE\n" +
                "ABF\n" +
                "ABG\n" +
                "ABH\n" +
                "ABI\n" +
                "ABJ\n" +
                "ABK\n" +
                "ABL\n" +
                "ABM\n" +
                "ABN\n" +
                "ABO\n" +
                "ABP\n" +
                "ABQ\n" +
                "ABR\n" +
                "ABS\n" +
                "ABT\n" +
                "ABU\n" +
                "ABV\n" +
                "ABW\n" +
                "ABX\n" +
                "ABY\n" +
                "ACZ\n" +
                "ACA\n" +
                "ACB\n" +
                "ACC\n" +
                "ACD\n" +
                "ACE\n" +
                "ACF\n" +
                "ACG\n" +
                "ACH\n" +
                "ACI\n" +
                "ACJ\n" +
                "ACK\n" +
                "ACL\n" +
                "ACM\n" +
                "ACN\n" +
                "ACO\n" +
                "ACP\n" +
                "ACQ\n" +
                "ACR\n" +
                "ACS\n" +
                "ACT\n" +
                "ACU\n" +
                "ACV\n" +
                "ACW\n" +
                "ACX\n" +
                "ACY\n" +
                "ADZ\n" +
                "ADA\n" +
                "ADB\n" +
                "ADC\n" +
                "ADD\n" +
                "ADE\n" +
                "ADF\n" +
                "ADG\n" +
                "ADH\n" +
                "ADI\n" +
                "ADJ\n" +
                "ADK\n" +
                "ADL\n" +
                "ADM\n" +
                "ADN\n" +
                "ADO\n" +
                "ADP\n" +
                "ADQ\n" +
                "ADR\n" +
                "ADS\n" +
                "ADT\n" +
                "ADU\n" +
                "ADV\n" +
                "ADW\n" +
                "ADX\n" +
                "ADY\n" +
                "AEZ\n" +
                "AEA\n" +
                "AEB\n" +
                "AEC\n" +
                "AED\n" +
                "AEE\n" +
                "AEF\n" +
                "AEG\n" +
                "AEH\n" +
                "AEI\n" +
                "AEJ\n" +
                "AEK\n" +
                "AEL\n" +
                "AEM\n" +
                "AEN\n" +
                "AEO\n" +
                "AEP\n" +
                "AEQ\n" +
                "AER\n" +
                "AES\n" +
                "AET\n" +
                "AEU\n" +
                "AEV\n" +
                "AEW\n" +
                "AEX\n" +
                "AEY\n" +
                "AFZ\n" +
                "AFA\n" +
                "AFB\n" +
                "AFC\n" +
                "AFD\n" +
                "AFE\n" +
                "AFF\n" +
                "AFG\n" +
                "AFH\n" +
                "AFI\n" +
                "AFJ\n" +
                "AFK\n" +
                "AFL\n" +
                "AFM\n" +
                "AFN\n" +
                "AFO\n" +
                "AFP\n" +
                "AFQ\n" +
                "AFR\n" +
                "AFS\n" +
                "AFT\n" +
                "AFU\n" +
                "AFV\n" +
                "AFW\n" +
                "AFX\n" +
                "AFY\n" +
                "AGZ\n" +
                "AGA\n" +
                "AGB\n" +
                "AGC\n" +
                "AGD\n" +
                "AGE\n" +
                "AGF\n" +
                "AGG\n" +
                "AGH\n" +
                "AGI\n" +
                "AGJ\n" +
                "AGK\n" +
                "AGL\n" +
                "AGM\n" +
                "AGN\n" +
                "AGO\n" +
                "AGP\n" +
                "AGQ\n" +
                "AGR\n" +
                "AGS\n" +
                "AGT\n" +
                "AGU\n" +
                "AGV\n" +
                "AGW\n" +
                "AGX\n" +
                "AGY\n" +
                "AHZ\n" +
                "AHA\n" +
                "AHB\n" +
                "AHC\n" +
                "AHD\n" +
                "AHE\n" +
                "AHF\n" +
                "AHG\n" +
                "AHH\n" +
                "AHI\n" +
                "AHJ\n" +
                "AHK\n" +
                "AHL\n" +
                "AHM\n" +
                "AHN\n" +
                "AHO\n" +
                "AHP\n" +
                "AHQ\n" +
                "AHR\n" +
                "AHS\n" +
                "AHT\n" +
                "AHU\n" +
                "AHV\n" +
                "AHW\n" +
                "AHX\n" +
                "AHY\n" +
                "AIZ\n" +
                "AIA\n" +
                "AIB\n" +
                "AIC\n" +
                "AID\n" +
                "AIE\n" +
                "AIF\n" +
                "AIG\n" +
                "AIH\n" +
                "AII\n" +
                "AIJ\n" +
                "AIK\n" +
                "AIL\n" +
                "AIM\n" +
                "AIN\n" +
                "AIO\n" +
                "AIP\n" +
                "AIQ\n" +
                "AIR\n" +
                "AIS\n" +
                "AIT\n" +
                "AIU\n" +
                "AIV\n" +
                "AIW\n" +
                "AIX\n" +
                "AIY\n" +
                "AJZ\n" +
                "AJA\n" +
                "AJB\n" +
                "AJC\n" +
                "AJD\n" +
                "AJE\n" +
                "AJF\n" +
                "AJG\n" +
                "AJH\n" +
                "AJI\n" +
                "AJJ\n" +
                "AJK\n" +
                "AJL\n" +
                "AJM\n" +
                "AJN\n" +
                "AJO\n" +
                "AJP\n" +
                "AJQ\n" +
                "AJR\n" +
                "AJS\n" +
                "AJT\n" +
                "AJU\n" +
                "AJV\n" +
                "AJW\n" +
                "AJX\n" +
                "AJY\n" +
                "AKZ\n" +
                "AKA\n" +
                "AKB\n" +
                "AKC\n" +
                "AKD\n" +
                "AKE\n" +
                "AKF\n" +
                "AKG\n" +
                "AKH\n" +
                "AKI\n" +
                "AKJ\n" +
                "AKK\n" +
                "AKL\n" +
                "AKM\n" +
                "AKN\n" +
                "AKO\n" +
                "AKP\n" +
                "AKQ\n" +
                "AKR\n" +
                "AKS\n" +
                "AKT\n" +
                "AKU\n" +
                "AKV\n" +
                "AKW\n" +
                "AKX\n" +
                "AKY\n" +
                "ALZ\n" +
                "ALA\n" +
                "ALB\n" +
                "ALC\n" +
                "ALD\n" +
                "ALE\n" +
                "ALF\n" +
                "ALG\n" +
                "ALH\n" +
                "ALI\n" +
                "ALJ\n" +
                "ALK\n" +
                "ALL\n" +
                "ALM\n" +
                "ALN\n" +
                "ALO\n" +
                "ALP\n" +
                "ALQ\n" +
                "ALR\n" +
                "ALS\n" +
                "ALT\n" +
                "ALU\n" +
                "ALV\n" +
                "ALW\n" +
                "ALX\n" +
                "ALY\n" +
                "AMZ\n" +
                "AMA\n" +
                "AMB\n" +
                "AMC\n" +
                "AMD\n" +
                "AME\n" +
                "AMF\n" +
                "AMG\n" +
                "AMH\n" +
                "AMI\n" +
                "AMJ\n" +
                "AMK\n" +
                "AML\n" +
                "AMM\n" +
                "AMN\n" +
                "AMO\n" +
                "AMP\n" +
                "AMQ\n" +
                "AMR\n" +
                "AMS\n" +
                "AMT\n" +
                "AMU\n" +
                "AMV\n" +
                "AMW\n" +
                "AMX\n" +
                "AMY\n" +
                "ANZ\n" +
                "ANA\n" +
                "ANB\n" +
                "ANC\n" +
                "AND\n" +
                "ANE\n" +
                "ANF\n" +
                "ANG\n" +
                "ANH\n" +
                "ANI\n" +
                "ANJ\n" +
                "ANK\n" +
                "ANL\n" +
                "ANM\n" +
                "ANN\n" +
                "ANO\n" +
                "ANP\n" +
                "ANQ\n" +
                "ANR\n" +
                "ANS\n" +
                "ANT\n" +
                "ANU\n" +
                "ANV\n" +
                "ANW\n" +
                "ANX\n" +
                "ANY\n" +
                "AOZ\n" +
                "AOA\n" +
                "AOB\n" +
                "AOC\n" +
                "AOD\n" +
                "AOE\n" +
                "AOF\n" +
                "AOG\n" +
                "AOH\n" +
                "AOI\n" +
                "AOJ\n" +
                "AOK\n" +
                "AOL\n" +
                "AOM\n" +
                "AON\n" +
                "AOO\n" +
                "AOP\n" +
                "AOQ\n" +
                "AOR\n" +
                "AOS\n" +
                "AOT\n" +
                "AOU\n" +
                "AOV\n" +
                "AOW\n" +
                "AOX\n" +
                "AOY\n" +
                "APZ\n" +
                "APA\n" +
                "APB\n" +
                "APC\n" +
                "APD\n" +
                "APE\n" +
                "APF\n" +
                "APG\n" +
                "APH\n" +
                "API\n" +
                "APJ\n" +
                "APK\n" +
                "APL\n" +
                "APM\n" +
                "APN\n" +
                "APO\n" +
                "APP\n" +
                "APQ\n" +
                "APR\n" +
                "APS\n" +
                "APT\n" +
                "APU\n" +
                "APV\n" +
                "APW\n" +
                "APX\n" +
                "APY\n" +
                "AQZ\n" +
                "AQA\n" +
                "AQB\n" +
                "AQC\n" +
                "AQD\n" +
                "AQE\n" +
                "AQF\n" +
                "AQG\n" +
                "AQH\n" +
                "AQI\n" +
                "AQJ\n" +
                "AQK\n" +
                "AQL\n" +
                "AQM\n" +
                "AQN\n" +
                "AQO\n" +
                "AQP\n" +
                "AQQ\n" +
                "AQR\n" +
                "AQS\n" +
                "AQT\n" +
                "AQU\n" +
                "AQV\n" +
                "AQW\n" +
                "AQX\n" +
                "AQY\n" +
                "ARZ\n" +
                "ARA\n" +
                "ARB\n" +
                "ARC\n" +
                "ARD\n" +
                "ARE\n" +
                "ARF\n" +
                "ARG\n" +
                "ARH\n" +
                "ARI\n" +
                "ARJ\n" +
                "ARK\n" +
                "ARL\n" +
                "ARM\n" +
                "ARN\n" +
                "ARO\n" +
                "ARP\n" +
                "ARQ\n" +
                "ARR\n" +
                "ARS\n" +
                "ART\n" +
                "ARU\n" +
                "ARV\n" +
                "ARW\n" +
                "ARX\n" +
                "ARY\n" +
                "ASZ\n" +
                "ASA\n" +
                "ASB\n" +
                "ASC\n" +
                "ASD\n" +
                "ASE\n" +
                "ASF\n" +
                "ASG\n" +
                "ASH\n" +
                "ASI\n" +
                "ASJ\n" +
                "ASK\n" +
                "ASL\n" +
                "ASM\n" +
                "ASN\n" +
                "ASO\n" +
                "ASP\n" +
                "ASQ\n" +
                "ASR\n" +
                "ASS\n" +
                "AST\n" +
                "ASU\n" +
                "ASV\n" +
                "ASW\n" +
                "ASX\n" +
                "ASY\n" +
                "ATZ\n" +
                "ATA\n" +
                "ATB\n" +
                "ATC\n" +
                "ATD\n" +
                "ATE\n" +
                "ATF\n" +
                "ATG\n" +
                "ATH\n" +
                "ATI\n" +
                "ATJ\n" +
                "ATK\n" +
                "ATL\n" +
                "ATM\n" +
                "ATN\n" +
                "ATO\n" +
                "ATP\n" +
                "ATQ\n" +
                "ATR\n" +
                "ATS\n" +
                "ATT\n" +
                "ATU\n" +
                "ATV\n" +
                "ATW\n" +
                "ATX\n" +
                "ATY\n" +
                "AUZ\n" +
                "AUA\n" +
                "AUB\n" +
                "AUC\n" +
                "AUD\n" +
                "AUE\n" +
                "AUF\n" +
                "AUG\n" +
                "AUH\n" +
                "AUI\n" +
                "AUJ\n" +
                "AUK\n" +
                "AUL\n" +
                "AUM\n" +
                "AUN\n" +
                "AUO\n" +
                "AUP\n" +
                "AUQ\n" +
                "AUR\n" +
                "AUS\n" +
                "AUT\n" +
                "AUU\n" +
                "AUV\n" +
                "AUW\n" +
                "AUX\n" +
                "AUY\n" +
                "AVZ\n" +
                "AVA\n" +
                "AVB\n" +
                "AVC\n" +
                "AVD\n" +
                "AVE\n" +
                "AVF\n" +
                "AVG\n" +
                "AVH\n" +
                "AVI\n" +
                "AVJ\n" +
                "AVK\n" +
                "AVL\n" +
                "AVM\n" +
                "AVN\n" +
                "AVO\n" +
                "AVP\n" +
                "AVQ\n" +
                "AVR\n" +
                "AVS\n" +
                "AVT\n" +
                "AVU\n" +
                "AVV\n" +
                "AVW\n" +
                "AVX\n" +
                "AVY\n" +
                "AWZ\n" +
                "AWA\n" +
                "AWB\n" +
                "AWC\n" +
                "AWD\n" +
                "AWE\n" +
                "AWF\n" +
                "AWG\n" +
                "AWH\n" +
                "AWI\n" +
                "AWJ\n" +
                "AWK\n" +
                "AWL\n" +
                "AWM\n" +
                "AWN\n" +
                "AWO\n" +
                "AWP\n" +
                "AWQ\n" +
                "AWR\n" +
                "AWS\n" +
                "AWT\n" +
                "AWU\n" +
                "AWV\n" +
                "AWW\n" +
                "AWX\n" +
                "AWY\n" +
                "AXZ\n" +
                "AXA\n" +
                "AXB\n" +
                "AXC\n" +
                "AXD\n" +
                "AXE\n" +
                "AXF\n" +
                "AXG\n" +
                "AXH\n" +
                "AXI\n" +
                "AXJ\n" +
                "AXK\n" +
                "AXL\n" +
                "AXM\n" +
                "AXN\n" +
                "AXO\n" +
                "AXP\n" +
                "AXQ\n" +
                "AXR\n" +
                "AXS\n" +
                "AXT\n" +
                "AXU\n" +
                "AXV\n" +
                "AXW\n" +
                "AXX\n" +
                "AXY\n" +
                "AYZ\n" +
                "AYA\n" +
                "AYB\n" +
                "AYC\n" +
                "AYD\n" +
                "AYE\n" +
                "AYF\n" +
                "AYG\n" +
                "AYH\n" +
                "AYI\n" +
                "AYJ\n" +
                "AYK\n" +
                "AYL\n" +
                "AYM\n" +
                "AYN\n" +
                "AYO\n" +
                "AYP\n" +
                "AYQ\n" +
                "AYR\n" +
                "AYS\n" +
                "AYT\n" +
                "AYU\n" +
                "AYV\n" +
                "AYW\n" +
                "AYX\n" +
                "AYY\n" +
                "BZZ\n" +
                "BZA\n" +
                "BZB\n" +
                "BZC\n" +
                "BZD\n" +
                "BZE\n" +
                "BZF\n" +
                "BZG\n" +
                "BZH\n" +
                "BZI\n" +
                "BZJ\n" +
                "BZK\n" +
                "BZL\n" +
                "BZM\n" +
                "BZN\n" +
                "BZO\n" +
                "BZP\n" +
                "BZQ\n" +
                "BZR\n" +
                "BZS\n" +
                "BZT\n" +
                "BZU\n" +
                "BZV\n" +
                "BZW\n" +
                "BZX\n" +
                "BZY\n" +
                "BAZ\n" +
                "BAA\n" +
                "BAB\n" +
                "BAC\n" +
                "BAD\n" +
                "BAE\n" +
                "BAF\n" +
                "BAG\n" +
                "BAH\n" +
                "BAI\n" +
                "BAJ\n" +
                "BAK\n" +
                "BAL\n" +
                "BAM\n" +
                "BAN\n" +
                "BAO\n" +
                "BAP\n" +
                "BAQ\n" +
                "BAR\n" +
                "BAS\n" +
                "BAT\n" +
                "BAU\n" +
                "BAV\n" +
                "BAW\n" +
                "BAX\n" +
                "BAY\n" +
                "BBZ\n" +
                "BBA\n" +
                "BBB\n" +
                "BBC\n" +
                "BBD\n" +
                "BBE\n" +
                "BBF\n" +
                "BBG\n" +
                "BBH\n" +
                "BBI\n" +
                "BBJ\n" +
                "BBK\n" +
                "BBL\n" +
                "BBM\n" +
                "BBN\n" +
                "BBO\n" +
                "BBP\n" +
                "BBQ\n" +
                "BBR\n" +
                "BBS\n" +
                "BBT\n" +
                "BBU\n" +
                "BBV\n" +
                "BBW\n" +
                "BBX\n" +
                "BBY\n" +
                "BCZ\n" +
                "BCA\n" +
                "BCB\n" +
                "BCC\n" +
                "BCD\n" +
                "BCE\n" +
                "BCF\n" +
                "BCG\n" +
                "BCH\n" +
                "BCI\n" +
                "BCJ\n" +
                "BCK\n" +
                "BCL\n" +
                "BCM\n" +
                "BCN\n" +
                "BCO\n" +
                "BCP\n" +
                "BCQ\n" +
                "BCR\n" +
                "BCS\n" +
                "BCT\n" +
                "BCU\n" +
                "BCV\n" +
                "BCW\n" +
                "BCX\n" +
                "BCY\n" +
                "BDZ\n" +
                "BDA\n" +
                "BDB\n" +
                "BDC\n" +
                "BDD\n" +
                "BDE\n" +
                "BDF\n" +
                "BDG\n" +
                "BDH\n" +
                "BDI\n" +
                "BDJ\n" +
                "BDK\n" +
                "BDL\n" +
                "BDM\n" +
                "BDN\n" +
                "BDO\n" +
                "BDP\n" +
                "BDQ\n" +
                "BDR\n" +
                "BDS\n" +
                "BDT\n" +
                "BDU\n" +
                "BDV\n" +
                "BDW\n" +
                "BDX\n" +
                "BDY\n" +
                "BEZ\n" +
                "BEA\n" +
                "BEB\n" +
                "BEC\n" +
                "BED\n" +
                "BEE\n" +
                "BEF\n" +
                "BEG\n" +
                "BEH\n" +
                "BEI\n" +
                "BEJ\n" +
                "BEK\n" +
                "BEL\n" +
                "BEM\n" +
                "BEN\n" +
                "BEO\n" +
                "BEP\n" +
                "BEQ\n" +
                "BER\n" +
                "BES\n" +
                "BET\n" +
                "BEU\n" +
                "BEV\n" +
                "BEW\n" +
                "BEX\n" +
                "BEY\n" +
                "BFZ\n" +
                "BFA\n" +
                "BFB\n" +
                "BFC\n" +
                "BFD\n" +
                "BFE\n" +
                "BFF\n" +
                "BFG\n" +
                "BFH\n" +
                "BFI\n" +
                "BFJ\n" +
                "BFK\n" +
                "BFL\n" +
                "BFM\n" +
                "BFN\n" +
                "BFO\n" +
                "BFP\n" +
                "BFQ\n" +
                "BFR\n" +
                "BFS\n" +
                "BFT\n" +
                "BFU\n" +
                "BFV\n" +
                "BFW\n" +
                "BFX\n" +
                "BFY\n" +
                "BGZ\n" +
                "BGA\n" +
                "BGB\n" +
                "BGC\n" +
                "BGD\n" +
                "BGE\n" +
                "BGF\n" +
                "BGG\n" +
                "BGH\n" +
                "BGI\n" +
                "BGJ\n" +
                "BGK\n" +
                "BGL\n" +
                "BGM\n" +
                "BGN\n" +
                "BGO\n" +
                "BGP\n" +
                "BGQ\n" +
                "BGR\n" +
                "BGS\n" +
                "BGT\n" +
                "BGU\n" +
                "BGV\n" +
                "BGW\n" +
                "BGX\n" +
                "BGY\n" +
                "BHZ\n" +
                "BHA\n" +
                "BHB\n" +
                "BHC\n" +
                "BHD\n" +
                "BHE\n" +
                "BHF\n" +
                "BHG\n" +
                "BHH\n" +
                "BHI\n" +
                "BHJ\n" +
                "BHK\n" +
                "BHL\n" +
                "BHM\n" +
                "BHN\n" +
                "BHO\n" +
                "BHP\n" +
                "BHQ\n" +
                "BHR\n" +
                "BHS\n" +
                "BHT\n" +
                "BHU\n" +
                "BHV\n" +
                "BHW\n" +
                "BHX\n" +
                "BHY\n" +
                "BIZ\n" +
                "BIA\n" +
                "BIB\n" +
                "BIC\n" +
                "BID\n" +
                "BIE\n" +
                "BIF\n" +
                "BIG\n" +
                "BIH\n" +
                "BII\n" +
                "BIJ\n" +
                "BIK\n" +
                "BIL\n" +
                "BIM\n" +
                "BIN\n" +
                "BIO\n" +
                "BIP\n" +
                "BIQ\n" +
                "BIR\n" +
                "BIS\n" +
                "BIT\n" +
                "BIU\n" +
                "BIV\n" +
                "BIW\n" +
                "BIX\n" +
                "BIY\n" +
                "BJZ\n" +
                "BJA\n" +
                "BJB\n" +
                "BJC\n" +
                "BJD\n" +
                "BJE\n" +
                "BJF\n" +
                "BJG\n" +
                "BJH\n" +
                "BJI\n" +
                "BJJ\n" +
                "BJK\n" +
                "BJL\n" +
                "BJM\n" +
                "BJN\n" +
                "BJO\n" +
                "BJP\n" +
                "BJQ\n" +
                "BJR\n" +
                "BJS\n" +
                "BJT\n" +
                "BJU\n" +
                "BJV\n" +
                "BJW\n" +
                "BJX\n" +
                "BJY\n" +
                "BKZ\n" +
                "BKA\n" +
                "BKB\n" +
                "BKC\n" +
                "BKD\n" +
                "BKE\n" +
                "BKF\n" +
                "BKG\n" +
                "BKH\n" +
                "BKI\n" +
                "BKJ\n" +
                "BKK\n" +
                "BKL\n" +
                "BKM\n" +
                "BKN\n" +
                "BKO\n" +
                "BKP\n" +
                "BKQ\n" +
                "BKR\n" +
                "BKS\n" +
                "BKT\n" +
                "BKU\n" +
                "BKV\n" +
                "BKW\n" +
                "BKX\n" +
                "BKY\n" +
                "BLZ\n" +
                "BLA\n" +
                "BLB\n" +
                "BLC\n" +
                "BLD\n" +
                "BLE\n" +
                "BLF\n" +
                "BLG\n" +
                "BLH\n" +
                "BLI\n" +
                "BLJ\n" +
                "BLK\n" +
                "BLL\n" +
                "BLM\n" +
                "BLN\n" +
                "BLO\n" +
                "BLP\n" +
                "BLQ\n" +
                "BLR\n" +
                "BLS\n" +
                "BLT\n" +
                "BLU\n" +
                "BLV\n" +
                "BLW\n" +
                "BLX\n" +
                "BLY\n" +
                "BMZ\n" +
                "BMA\n" +
                "BMB\n" +
                "BMC\n" +
                "BMD\n" +
                "BME\n" +
                "BMF\n" +
                "BMG\n" +
                "BMH\n" +
                "BMI\n" +
                "BMJ\n" +
                "BMK\n" +
                "BML").split("\n");
        String[] s2 = new String[s1.length];
        for(int i = 0; i < s1.length; i++) {
            s2[i] = s1[i];
        }
        Arrays.sort(s1);*/

        boolean valid = true;
        for(int i = 0; i < s1.length; i++) {
            if(!s1[i].equals(s2[i])) {
                valid = false;
                System.out.println(i + ":\t" +  s1[i] + ":" + s2[i]);
            }
        }
        if(valid) {
            System.out.println("VALID!");
        }
    }
}