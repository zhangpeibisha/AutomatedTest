package org.nix.utils.http;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.form.Form;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.nix.utils.json.JacksonUtil;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * cxf客户端请求实现工具类
 *
 * @author zhangpei
 * @version 1.0
 * @date 2018/7/3
 */
public class WebClientUtil {

    public final static String ESB_REQUEST_ID = "TP-REQUEST-ID";
    public final static String ESB_SERVICE_ID = "TP-SERVICE-ID";
    public final static String ESB_APP_ID = "TP-APP-ID";
    public final static String ESB_ACCESS_TOKEN = "TP-ACCESS-TOKEN";
    public final static String ESB_REQUEST_TIME = "TP-REQUEST-TIME";
    public final static String ESB_REQUEST_HASH = "TP-REQUEST-HASH";
    public final static String ESB_REQUEST_EXT = "TP-REQUEST-EXT";

    private static final String ENCODING = "UTF-8";

    /**
     * json
     */
    private static final String APPLICATION_JSON = "application/json";

    /**
     * xml
     */
    private static final String APPLICATION_XML = "text/xml";
    /**
     * form
     */
    private static final String APPLICATION_FORM = "application/x-www-form-urlencoded";

    private static final long defaultReciveTimeout = 60000;
    private static long reciveTimeout;

    /**
     * 设置HttpClient超时时间
     * <p>
     * 注意：因为是静态变量所以修改此处，会影响整个应用程序的超时。
     * 如果不想影响到其他处调用的超时，在每次调用请求方法后，
     * 需要再次调用 setDefaultTimeout()，恢复成默认设置。
     *
     * @param timeout
     */
    public static void setReciveTimeout(long timeout) {
        reciveTimeout = timeout;
    }

    public static void setDefaultTimeout() {
        reciveTimeout = defaultReciveTimeout;
        System.out.println("HttpClient default reciveTimeout is: " + reciveTimeout);
    }

    private static WebClient createClient(String url, List<Object> providers) {
        WebClient client;
        if (providers != null && providers.size() > 0) {
            client = WebClient.create(url, providers);
        } else {
            client = WebClient.create(url);
        }
        ClientConfiguration config = WebClient.getConfig(client);
        config.getHttpConduit().getClient().setReceiveTimeout(reciveTimeout);
        return client;
    }

    private static WebClient createClient(String url) {
        return createClient(url, null);
    }

    /**
     * post Json
     *
     * @param url 请求地址
     * @param o   POJO对象
     * @return 返回服务器响应
     */
    public static Object postJson(String url, Object o) throws IOException {
        o = JacksonUtil.bean2Json(o);
        List<Object> providers = new ArrayList<Object>();
        // 配置json转换器
        providers.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());
        // 创建Webclient对象
        WebClient client = createClient(url, providers);
        // 发送请求，服务器返回响应
        Object res = client.accept(APPLICATION_JSON).type(APPLICATION_JSON)
                .post(o, o.getClass());
        return res;
    }

    /**
     * post Xml
     *
     * @param url 请求地址
     * @param o   POJO对象
     * @return 返回服务器响应
     */
    public static Response postXML(String url, Object o) {
        // 创建创建Web client对象
        WebClient client = createClient(url);
        // 发送请求，服务器返回响应
        Response res = client.accept(APPLICATION_XML).type(APPLICATION_XML)
                .post(o);
        return res;
    }

    /**
     * post Xml with additional headers
     *
     * @param url 请求地址
     * @param o   POJO对象
     * @return 返回服务器响应
     */
    public static Response postXML(String url, Object o, Map<String, String> addHeaders) {
        // 创建创建Web client对象
        WebClient client = createClient(url);
        addHeaders(client, addHeaders);
        // 发送请求，服务器返回响应
        Response res = client.accept(APPLICATION_XML).type(APPLICATION_XML)
                .post(o);
        return res;
    }

    /**
     * post object to xml
     *
     * @param url 请求地址
     * @param o   POJO对象
     * @return 返回服务器响应
     */
    public static Object postXML(String url, Object o, Class<?> clazz) {
        // 创建创建Web client对象
        WebClient client = createClient(url);
        // 发送请求，服务器返回响应
        Object res = client.accept(APPLICATION_XML).type(APPLICATION_XML)
                .post(o, clazz);
        return res;
    }

    public static Object postXML(String url, Object o, Class<?> clazz, Map<String, String> addHeaders) {
        // 创建创建Web client对象
        WebClient client = createClient(url);
        addHeaders(client, addHeaders);
        // 发送请求，服务器返回响应
        Object res = client.accept(APPLICATION_XML).type(APPLICATION_XML)
                .post(o, clazz);
        return res;
    }

    /**
     * get xml
     *
     * @param url 请求地址
     * @param o   POJO对象
     * @return 返回服务器响应
     */
    public static Object getXML(String url, Object o) {
        // 创建创建Web client对象
        WebClient client = createClient(url);
        // 发送请求，服务器返回响应
        Object obj = client.accept(APPLICATION_XML).type(APPLICATION_XML)
                .get(o.getClass());
        return obj;
    }

    public static Object getXML(String url, Object o, Map<String, String> addHeaders) {
        // 创建创建Web client对象
        WebClient client = createClient(url);
        addHeaders(client, addHeaders);
        // 发送请求，服务器返回响应
        Object obj = client.accept(APPLICATION_XML).type(APPLICATION_XML)
                .get(o.getClass());
        return obj;
    }

    /**
     * get json
     *
     * @param url 请求地址
     * @param o   POJO对象
     * @return 返回服务器响应
     */
    public static Object getJson(String url, Object o) {
        // 创建创建Web client对象
        WebClient client = createClient(url);
        // 发送请求，服务器返回响应
        Object obj = client.accept(APPLICATION_JSON).type(APPLICATION_JSON)
                .get(o.getClass());
        return obj;
    }

    public static Object getJson(String url, Object o, Map<String, String> addHeaders) {
        // 创建创建Web client对象
        WebClient client = createClient(url);
        addHeaders(client, addHeaders);
        // 发送请求，服务器返回响应
        Object obj = client.accept(APPLICATION_JSON).type(APPLICATION_JSON)
                .get(o.getClass());
        return obj;
    }

    /**
     * post XML重载，返回Response信息
     *
     * @param url    请求地址
     * @param o      实体类对象
     * @param xmlStr xml字符串
     * @return 返回服务器响应信息
     * @throws IOException       异常
     * @throws TemplateException 异常
     */
    public static Response postXML(String url, Object o, String xmlStr) {
        String toPostXML = writeXML(o, xmlStr);
        // 创建创建Web client对象
        WebClient client = createClient(url);
        // 发送请求,返回响应信息
        Response res = client.post(toPostXML);
        return res;
    }

    public static Response postFormRequest(String url, Map<String, String> formValues, Map<String, String> addHeaders) {
        WebClient client = createClient(url);
        Form form = new Form();
        addHeaders(client, addHeaders);
        Set<String> keys = formValues.keySet();
        for (String key : keys) {
            form.set(key, formValues.get(key));
        }
        return client.form(form);
    }

    /**
     * POST FORM表单
     *
     * @param <T>        返回类型(String.class, xxx.class等)
     * @param url        请求url
     * @param formValues 表单数据(Map)
     * @param addHeaders 表头数据(Map)
     * @param clazz      返回类型(String.class, xxx.class等)
     * @return 返回指定类型的对象
     */
    public static <T> T postForm(String url, Map<String, String> formValues, Map<String, String> addHeaders, Class clazz) {
        Response res = postFormRequest(url, formValues, addHeaders);
        return (T) res.readEntity(clazz);
    }

    /**
     * POST FORM表单
     *
     * @param <T>
     * @param url        请求url
     * @param formValues 表单数据(Map)
     * @param clazz      返回类型(String.class, xxx.class等)
     * @return
     */
    public static <T> T postForm(String url, Map<String, String> formValues, Class clazz) {
        Response res = postFormRequest(url, formValues, null);
        return (T) res.readEntity(clazz);
    }

    private static void addHeaders(WebClient client, Map<String, String> addHeaders) {
        if (addHeaders != null) {
            Set<String> keys = addHeaders.keySet();
            for (String key : keys) {
                client.header(key, addHeaders.get(key));
            }
        }
    }


    /**
     * 服务器请求
     *
     * @param url    请求路径
     * @param posMap map对象
     * @return 服务器响应信息
     * @throws Exception
     * @throws ParseException
     */
    public static HttpResponse postXMl(String url, Map<String, String> posMap) throws ParseException, Exception {
        // 创建HttpClient
        DefaultHttpClient client = new DefaultHttpClient();
        List<BasicNameValuePair> namePairs = new ArrayList<BasicNameValuePair>();
        HttpPost httppost = new HttpPost(url);
        // Map参数转化为键值对
        for (Map.Entry<String, String> entry : posMap.entrySet()) {
            BasicNameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue());
            namePairs.add(pair);
        }
        //
        httppost.setEntity(new UrlEncodedFormEntity(namePairs, "UTF-8"));

        // 发送请求
        HttpResponse res = client.execute(httppost);
        return res;
    }

    /**
     * 将对象值写入XML模板中
     *
     * @param o      实体类对象
     * @param xmlStr 模板xml字符串
     * @return 返回xml字符串
     * @throws IOException       异常
     * @throws TemplateException 异常
     */
    public static String writeXML(Object o, String xmlStr) {
        // 创建Configuration对象
        Configuration cfg = new Configuration();
        // 创建StringTemplateLoader对象
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        // 传入的xml字符串
        stringLoader.putTemplate("xmlTemplate", xmlStr);
        // 设定模板
        cfg.setTemplateLoader(stringLoader);
        // 创建StringWriter对象
        StringWriter out = new StringWriter();
        // 获取字符串模板
        try {
            Template template = cfg.getTemplate("xmlTemplate");
            // 对象值写入xml模板
            template.process(o, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toString();
    }

    public static void main(String[] args) {

    }

}
