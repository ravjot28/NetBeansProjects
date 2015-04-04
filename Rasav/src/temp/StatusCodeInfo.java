/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package temp;

import java.util.HashMap;

/**
 *
 * @author Rav
 */
public class StatusCodeInfo {

    public HashMap<Integer, String> statusCode = new HashMap<>();

    public StatusCodeInfo() {
    }

    public void set1XXStatusCode() {
        statusCode.put(100, "The server has received the request headers, "
                + "and that the client should proceed to send the request body "
                + "(in the case of a request for which a body needs to be sent; for example, "
                + "a POST request)");
        statusCode.put(101, "The requester has asked the server to switch protocols and "
                + "the server is acknowledging that it will do so");
        statusCode.put(102, "The server has received and is processing the request, "
                + "but no response is available yet");
    }

    public void set2XXStatusCode() {
        statusCode.put(200, "Standard response for successful HTTP requests");
        statusCode.put(201, "The request has been fulfilled and "
                + "resulted in a new resource being created");
        statusCode.put(202, "The request has been accepted for processing, "
                + "but the processing has not been completed");
        statusCode.put(203, "The server successfully processed the request, "
                + "but is returning information that may be from another source");
        statusCode.put(204, "The server successfully processed the request, "
                + "but is not returning any content");
        statusCode.put(205, "The server successfully processed the request, "
                + "but is not returning any content");
        statusCode.put(206, "The server is delivering only part of the resource "
                + "due to a range header sent by the client");
        statusCode.put(207, "The message body that follows is an XML message "
                + "and contain a number of separate response codes");
        statusCode.put(208, "The members of a DAV binding have already been enumerated "
                + "in a previous reply to this request, "
                + "and are not being included again");
        statusCode.put(226, "The server has fulfilled a GET request for the resource");
    }

    public void set3XXStatusCode() {
        statusCode.put(300, "Indicates multiple options for the resource that the client may follow");
        statusCode.put(301, "This and all future requests should be directed to the given URI");
        statusCode.put(302, "The HTTP/1.0 specification (RFC 1945) "
                + "required the client to perform a temporary redirect");
        statusCode.put(303, "The response to the request can be found under another "
                + "URI using a GET method");
        statusCode.put(304, "Indicates that the resource has not been modified "
                + "since the version specified by the request headers If-Modified-Since or If-Match");
        statusCode.put(305, "The requested resource is only available through a proxy, "
                + "whose address is provided in the response");
        statusCode.put(306, "No longer used");
        statusCode.put(307, "In this case, the request should be repeated with another URI");
        statusCode.put(308, "The request, and all future requests should be repeated using another URI");
    }

    public void set4XXStatusCode() {
        statusCode.put(400, "The request cannot be fulfilled due to bad syntax");
        statusCode.put(401, "Authentication is required and has failed or has not yet been provided");
        statusCode.put(402, "Reserved for future use");
        statusCode.put(403, "The request was a valid request, but the server "
                + "is refusing to respond to it");
        statusCode.put(404, "The requested resource could not be found but may "
                + "be available again in the future");
        statusCode.put(405, "A request was made of a resource using a request method not "
                + "supported by that resource");
        statusCode.put(406, "The requested resource is only capable of generating "
                + "content not acceptable according to the Accept headers sent in the request");
        statusCode.put(407, "The client must first authenticate itself with the proxy");
        statusCode.put(408, "The server timed out waiting for the request");
        statusCode.put(409, "Indicates that the request could not be processed "
                + "because of conflict in the request, such as an edit conflict in "
                + "the case of multiple updates");
        statusCode.put(410, "Indicates that the resource requested is no longer "
                + "available and will not be available again");
        statusCode.put(411, "The request did not specify the length of its content, "
                + "which is required by the requested resource");
        statusCode.put(412, "The server does not meet one of the preconditions "
                + "that the requester put on the request");
        statusCode.put(413, "The request is larger than the server is willing or able to process");
        statusCode.put(414, "The URI provided was too long for the server to process");
        statusCode.put(415, "The request entity has a media type which the "
                + "server or resource does not support");
        statusCode.put(416, "The client has asked for a portion of the file, "
                + "but the server cannot supply that portion");
        statusCode.put(417, "The server cannot meet the requirements of the "
                + "Expect request-header field");
        statusCode.put(418, "This code was defined in 1998 as one of the traditional "
                + "IETF April Fools' jokes, in RFC 2324, Hyper Text Coffee Pot Control Protocol, "
                + "and is not expected to be implemented by actual HTTP servers");
        statusCode.put(419, "Not a part of the HTTP standard, "
                + "419 Authentication Timeout denotes that previously "
                + "valid authentication has expired");
        statusCode.put(420, "Not part of the HTTP standard, but defined by Spring in the "
                + "HttpStatus class to be used when a method failed");
        statusCode.put(422, "The request was well-formed "
                + "but was unable to be followed due to semantic errors");
        statusCode.put(423, "The resource that is being accessed is locked");
        statusCode.put(424, "The request failed due to failure of a "
                + "previous request (e.g., a PROPPATCH)");
        statusCode.put(425, "Defined in drafts of "
                + "\"WebDAV Advanced Collections Protocol\",[15] "
                + "but not present in \"Web Distributed Authoring and Versioning (WebDAV) "
                + "Ordered Collections Protocol\"");
        statusCode.put(426, "The client should switch to a different protocol such as TLS/1.0");
        statusCode.put(428, "The origin server requires the request to be conditional");
        statusCode.put(429, "The user has sent too many requests in a given amount of time. "
                + "Intended for use with rate limiting schemes");
        statusCode.put(431, "The server is unwilling to process the request "
                + "because either an individual header field, "
                + "or all the header fields collectively, are too large");
        statusCode.put(444, "Used in Nginx logs to indicate that the server has returned no "
                + "information to the client and closed the connection (useful as a deterrent for malware)");
        statusCode.put(449, "The request should be retried after performing the appropriate action");
        statusCode.put(450, "This error is given when Windows Parental Controls "
                + "are turned on and are blocking access to the given webpage");
        statusCode.put(451, "Used in Exchange ActiveSync if there either "
                + "is a more efficient server to use or the server can't access the users' mailbox");
        statusCode.put(494, "Nginx internal code similar to 431 but it was introduced earlier");
        statusCode.put(495, "Nginx internal code used when SSL client certificate error occurred "
                + "to distinguish it from 4XX in a log and an error page redirection");
        statusCode.put(496, "Nginx internal code used when client didn't provide "
                + "certificate to distinguish it from 4XX in a log and an error page redirection");
        statusCode.put(497, "Nginx internal code used for the plain HTTP requests "
                + "that are sent to HTTPS port to distinguish it from 4XX in a log and an error page redirection");
        statusCode.put(499, "Used in Nginx logs to indicate when the connection has been closed by client "
                + "while the server is still processing its request, making server unable to send a status code back");
    }

    public void set5XXStatusCode() {
        statusCode.put(500, "A generic error message, given when no more specific message is suitable");
        statusCode.put(501, "The server either does not recognize the request method, "
                + "or it lacks the ability to fulfil the request");
        statusCode.put(502, "The server was acting as a gateway or proxy and received an invalid response from the upstream server");
        statusCode.put(503, "The server is currently unavailable (because it is overloaded or down for maintenance)");
        statusCode.put(504, "The server was acting as a gateway or proxy and did not receive a timely response from the upstream server");
        statusCode.put(505, "The server does not support the HTTP protocol version used in the request");
        statusCode.put(506, "Transparent content negotiation for the request results in a circular reference");
        statusCode.put(507, "The server is unable to store the representation needed to complete the request");
        statusCode.put(508, "The server detected an infinite loop while processing the request");
        statusCode.put(509, "This status code, while used by many servers, is not specified in any RFCs");
        statusCode.put(510, "Further extensions to the request are required for the server to fulfil it");
        statusCode.put(511, "The client needs to authenticate to gain network access");
        statusCode.put(598, "This status code is not specified in any RFCs, but is used by Microsoft "
                + "HTTP proxies to signal a network read timeout behind the proxy to a client in front of the proxy");
        statusCode.put(599, "This status code is not specified in any RFCs, but is used by Microsoft HTTP proxies to signal a network connect timeout behind the proxy to a client in front of the proxy");
    }

    public String getStatusCodeInfo(int statusCode) {
        return this.statusCode.get(statusCode);
    }

    public String getStatus(int statusCode) {
        String status = null;
        if (statusCode >= 100 && statusCode < 300) {
            status = "UP";
        } else if (statusCode >= 300 && statusCode < 400) {
            status = "Needs Redirection";
        } else if (statusCode >= 400 && statusCode < 500) {
            status = "Client Error";
        } else {
            status = "DOWN";
        }
        return status;
    }
}
