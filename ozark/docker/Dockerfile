FROM glassfish/nightly
MAINTAINER Florian Hirsch

ADD libs/endorsed/* /glassfish4/glassfish/lib/endorsed/
ADD *.xml /glassfish4/glassfish/domains/domain1/config/
ADD start.sh /glassfish4/start.sh

VOLUME /db

CMD ["/glassfish4/start.sh"]
