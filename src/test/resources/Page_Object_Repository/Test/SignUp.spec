Page Header: Common Page Objects

#Object Definitions
=====================================================================================
btn_withtext							xpath					//a[text()='Sign up']
txtfield_name							xpath					//label[text()='${value}']/../..//input
btn_checkbox							xpath					//div[@class='custom-checkbox']//input[@name='${value}']
btn_withvalue							xpath					//input[@value='Create account']