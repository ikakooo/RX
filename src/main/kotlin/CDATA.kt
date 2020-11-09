import org.w3c.dom.Document
import org.xml.sax.InputSource
import sun.net.www.http.HttpClient
import java.io.StringReader
import javax.lang.model.element.Element
import javax.xml.parsers.DocumentBuilderFactory


object CDATA {
    fun main(){
        try {
            val client: HttpClient = DefaultHttpClient()
            val request = HttpGet("http://www.cbc.ca/cmlink/rss-technology")
            val response: HttpResponse = client.execute(request)
            val entity: HttpEntity = response.getEntity()
            val xml: String = EntityUtils.toString(entity)
            println(xml)
            val docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
            val `is` = InputSource()
            `is`.characterStream = StringReader(xml)
            val doc: Document = docBuilder.parse(`is`)

            /*<title>
			<![CDATA[ CBC | Technology News ]]>
			</title>*/
            val channel: Element = doc.getElementsByTagName("channel").item(0) as Element
            val title: Element = channel.getElementsByTagName("title").item(0) as Element

            //inside title-tag ..... there is another tag <![CDATA[   ]]>.... which typecast into CharacterData from Node
            res.setText(title.getChildNodes().item(0).getData())
        } catch (e: Exception) {
            e.printStackTrace()
        }
}
}