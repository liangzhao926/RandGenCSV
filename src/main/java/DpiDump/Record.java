package DpiDump;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ 
	"userImsi",
	"userImei",
	"nwApn",
	"nwChargingCharacteristics",
	"nwRatType",
	"nwMcc",
	"nwMnc",
	"nwLac",
	"nwCi",
	"nwSac",
	"nwRac",
	"nwTac",
	"nwEci",
	"appName", 
	"appProto"
	})
public class Record
{
    private String appName;

    private String isTetheringDetected = "true";

    private String destinationIpAddress;


    private Integer destinationPort;


    private String[] appGrps = {
            "web",
            "generic"
    };

    private String appProto;

    private String url="http://123.com";
            
    private Integer downlinkPkt = 0;
    private Integer downlinkBytes = 0;
    private Integer uplinkPkt = 0;
    private Integer uplinkBytes = 0;

    private String[] appAttributes = {"tethering-detection"};

    private String userImsi;

    private String userImei;

    private String nwMcc;

    private String nwChargingCharacteristics;

    private String nwApn;

    private String nwCi;

    private String nwMnc;

    private String nwTac;

    private String nwRac;

    private String nwLac;

    private String nwSac;

    private String nwEci;

    private String nwRatType;
    
    private String ratingGroup;
    
    public String getAppName ()
    {
        return appName;
    }

    public void setAppName (String appName)
    {
        this.appName = appName;
    }

    public String getIsTetheringDetected ()
    {
        return isTetheringDetected;
    }

    public void setIsTetheringDetected (String isTetheringDetected)
    {
        this.isTetheringDetected = isTetheringDetected;
    }

    public String getDestinationIpAddress ()
    {
        return destinationIpAddress;
    }

    public void setDestinationIpAddress (String destinationIpAddress)
    {
        this.destinationIpAddress = destinationIpAddress;
    }

    public int getDownlinkPkt ()
    {
        return downlinkPkt;
    }

    public void setDownlinkPkt (Integer downlinkPkt)
    {
        this.downlinkPkt = downlinkPkt;
    }

    public Integer getDestinationPort ()
    {
        return destinationPort;
    }

    public void setDestinationPort (Integer destinationPort)
    {
        this.destinationPort = destinationPort;
    }

    public Integer getUplinkPkt ()
    {
        return uplinkPkt;
    }

    public void setUplinkPkt (Integer uplinkPkt)
    {
        this.uplinkPkt = uplinkPkt;
    }

    public String[] getAppGrps ()
    {
        return appGrps;
    }

    public void setAppGrps (String[] appGrps)
    {
        this.appGrps = appGrps;
    }

    public String getAppProto ()
    {
        return appProto;
    }

    public void setAppProto (String appProto)
    {
        this.appProto = appProto;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public Integer getDownlinkBytes ()
    {
        return downlinkBytes;
    }

    public void setDownlinkBytes (Integer downlinkBytes)
    {
        this.downlinkBytes = downlinkBytes;
    }

    public Integer getUplinkBytes ()
    {
        return uplinkBytes;
    }

    public void setUplinkBytes (Integer uplinkBytes)
    {
        this.uplinkBytes = uplinkBytes;
    }

    public String[] getAppAttributes ()
    {
        return appAttributes;
    }

    public void setAppAttributes (String[] appAttributes)
    {
        this.appAttributes = appAttributes;
    }

    public String getUserImsi ()
    {
        return userImsi;
    }

    public void setUserImsi (String userImsi)
    {
        this.userImsi = userImsi;
    }

    public String getUserImei ()
    {
        return userImei;
    }

    public void setUserImei (String userImei)
    {
        this.userImei = userImei;
    }

    public void setNwMccMnc(String nwMccMnc) {
    	String[] parts = nwMccMnc.split("-", 2);
    	setNwMcc(parts[0]);
    	setNwMnc(parts[1]);
    }
    
    public String getNwMcc ()
    {
        return nwMcc;
    }

    public void setNwMcc (String nwMcc)
    {
        this.nwMcc = nwMcc;
    }

    public String getNwChargingCharacteristics ()
    {
        return nwChargingCharacteristics;
    }

    public void setNwChargingCharacteristics (String nwChargingCharacteristics)
    {
        this.nwChargingCharacteristics = nwChargingCharacteristics;
    }

    public String getNwApn ()
    {
        return nwApn;
    }

    public void setNwApn (String nwApn)
    {
        this.nwApn = nwApn;
    }

    public String getNwCi ()
    {
        return nwCi;
    }

    public void setNwCi (String nwCi)
    {
        this.nwCi = nwCi;
    }

    public String getNwMnc ()
    {
        return nwMnc;
    }

    public void setNwMnc (String nwMnc)
    {
        this.nwMnc = nwMnc;
    }

    public String getNwTac ()
    {
        return nwTac;
    }

    public void setNwTac (String nwTac)
    {
        this.nwTac = nwTac;
    }

    public String getNwRac ()
    {
        return nwRac;
    }

    public void setNwRac (String nwRac)
    {
        this.nwRac = nwRac;
    }

    public String getNwLac ()
    {
        return nwLac;
    }

    public void setNwLac (String nwLac)
    {
        this.nwLac = nwLac;
    }

    public String getNwSac ()
    {
        return nwSac;
    }

    public void setNwSac (String nwSac)
    {
        this.nwSac = nwSac;
    }

    public String getNwEci ()
    {
        return nwEci;
    }

    public void setNwEci (String nwEci)
    {
        this.nwEci = nwEci;
    }

    public String getNwRatType ()
    {
        return nwRatType;
    }

    public void setNwRatType (String nwRatType)
    {
        this.nwRatType = nwRatType;
    }
    
    public String getRatingGroup ()
    {
        return ratingGroup;
    }

    public void setRatingGroup (String ratingGroup)
    {
        this.ratingGroup = ratingGroup;
    }

    @Override
    public String toString()
    {
        return "[appName = "+appName+", isTetheringDetected = "+isTetheringDetected+", destinationIpAddress = "+destinationIpAddress+", downlinkPkt = "+downlinkPkt+", destinationPort = "+destinationPort+", uplinkPkt = "+uplinkPkt+", appGrps = "+appGrps+", appProto = "+appProto+", url = "+url+", downlinkBytes = "+downlinkBytes+", uplinkBytes = "+uplinkBytes.toString()+", appAttributes = "+appAttributes
        		+ ", userImsi = "+userImsi+", userImei = "+userImei
        		+ ", nwMcc = "+nwMcc+", nwChargingCharacteristics = "+nwChargingCharacteristics+", nwApn = "+nwApn+", nwCi = "+nwCi+", nwMnc = "+nwMnc+", nwTac = "+nwTac+", nwRac = "+nwRac+", nwLac = "+nwLac+", nwSac = "+nwSac+", nwEci = "+nwEci+", nwRatType = "+nwRatType
        		+ ", ratingGroup = "+ratingGroup
        		+"]";
        
    }

}
			
			