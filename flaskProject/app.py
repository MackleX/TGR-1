#For testing purpose's a taha, hani radi nkhali lik NLP w scrapping bjoj f blassa wa7da bla matb9a t7ma9
from flask import Flask, request, jsonify, Response
import http.client
import json
from amazonscrapper import fetchAmazonProducts
import py_eureka_client.eureka_client as eureka_client

from nlp import keywords_extraction

rest_port = 5000
eureka_client.init(eureka_server="http://localhost:8761/eureka",
                   app_name="amazonscrapper-service",
                    instance_ip="192.168.1.104",
                    instance_host="localhost"
                   ,
                    instance_port=rest_port)





app = Flask(__name__)
@app.route("/amazonscrapper", methods=['POST'])
def products():
    data = request.json

    keywords = data['keywords']
    page = data['page']
    filter_object = filter(lambda x: x != "", keywords)
    without_empty_strings = list(filter_object)

    new_variable = '%20'.join(without_empty_strings)



    data = fetchAmazonProducts(page,keywords);



    jsonData = json.loads(data)


    return jsonify(jsonData)


@app.route("/nlptext", methods=['POST'])
def keywords():
    data = request.json
    review = data['text']
    keyword = list(filter(None, keywords_extraction(review)))
    data = {}
    data['extractedKeywords'] = keyword
    json_data = json.dumps(data)






    return Response(json_data, mimetype='application/json')


if __name__ == "__main__":
    app.run(host='0.0.0.0', port= rest_port, debug=True)