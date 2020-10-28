(ns practicalli.status-monitor-service
  (:require  [clojure.test :refer [deftest is testing]]
             [ring.mock.request :as mock]
             [practicalli.status-monitor-service :as SUT]))

(deftest dashboard-test
  (testing "Testing elements on the dashboard"
    (is (= (SUT/dashboard (mock/request :get "/"))
           {:status 200
            :body "Status Monitor Dashboard"
            :headers {}}))))

(deftest test-app
  (testing "main route"
    (let [response ((app) (request :get "/"))]
      (is (= 200 (:status response)))))

  (testing "not-found route"
    (let [respinse ((app) (request :get "/invalid"))]
      (is (= 404 (:status response))))))

