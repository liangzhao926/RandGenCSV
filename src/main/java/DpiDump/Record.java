package DpiDump;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ 
	"imsiImei", 
	"appName", 
	"appProto"
	})
public class Record
{
	/*
	 * 
{
"imsiImei" : "460010000000000",
"appProto" : "app-proto-string",
"appName" : "app-name-string",
"appAttributes":
[
  "appAttributesString1",
  "appAttributesString2"
],
"appGrps" :
[
  "appGrpsString1",
  "appGrpsString2"
],
"uplinkPkt" : 10,
"uplinkBytes" : 1000,
"downlinkPkt" : 10,
"downlinkBytes" : 1000,
"isTetheringDetected" : true,
"url" : "http://123.com",
"destinationIpAddress":"22.22.22.22",
"destinationPort" : 24
}
	 */
    private String appName;

    private String isTetheringDetected = "true";

    private String imsiImei = "460010000000000";

    private String destinationIpAddress;


    private Integer destinationPort;


    private String[] appGrps;

    private String appProto;

    private String url="http://123.com";
            
    private Integer downlinkPkt = 0;
    private Integer downlinkBytes = 0;
    private Integer uplinkPkt = 0;
    private Integer uplinkBytes = 0;

    private String[] appAttributes;

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

    public String getImsiImei ()
    {
        return imsiImei;
    }

    public void setImsiImei (String imsiImei)
    {
        this.imsiImei = imsiImei;
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

    @Override
    public String toString()
    {
        return "[appName = "+appName+", isTetheringDetected = "+isTetheringDetected+", imsiImei = "+imsiImei+", destinationIpAddress = "+destinationIpAddress+", downlinkPkt = "+downlinkPkt+", destinationPort = "+destinationPort+", uplinkPkt = "+uplinkPkt+", appGrps = "+appGrps+", appProto = "+appProto+", url = "+url+", downlinkBytes = "+downlinkBytes+", uplinkBytes = "+uplinkBytes.toString()+", appAttributes = "+appAttributes+"]";
    }

}
			
			