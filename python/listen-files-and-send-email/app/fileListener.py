from os import listdir
from os.path import isfile
from os.path import join

from re import match

from smtplib import SMTP

from email import MIMEMultipart
from email import MIMEText
from email import MIMEBase
from email import encoders


def sendMsg(f):
    fromAdd = 'farrukhjon.sattorov@gmail.com'
    toAdd = 'farrukhjon.sattorov@gmail.com'

    server = SMTP('smtp.gmail.com:587')
    server.ehlo()

    server.starttls()

    server.login('farrukhjon.sattorov@gmail.com', 'passwd')

    server.sendmail(fromAdd, toAdd, f)
    server.quit()


def listenErrorFile(path, pattern):
    for f in listdir(path):
        if isfile(join(path, f)):
            result = match(pattern, f)
            if result:
                return f


def monitor():
    f = listenErrorFile('../testResource', 'test123')
    if f:
        sendMsg(f)


monitor()


