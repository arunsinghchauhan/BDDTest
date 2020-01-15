Page Header: Common Page Objects

#Object Definitions
====================================================================================
btn_withValue							xpath				//input[@value='${value}']
btn_withName							xpath				//button[text()='${value}']
link_withLabel                          xpath               //div[@class='span12']//a[text()='${value}']
inp_withLabel							xpath				//label[text()='${value}']/..//input
inp_descriptionField					xpath				//textarea[@name='${value}']
clk_btn									xpath				//input[@value='${value}']
====================================================================================