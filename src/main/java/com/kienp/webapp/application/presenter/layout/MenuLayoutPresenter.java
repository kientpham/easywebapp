package com.kienp.webapp.application.presenter.layout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kienp.webapp.userservice.service.UserService;

@Component(value="MenuLayoutPresenter")
public class MenuLayoutPresenter implements LayoutPresenter {
	
	@Autowired
	private UserService userService;

	@Override
	public List<String> getListFeatures() {
		// TODO Auto-generated method stub
		return userService.getListFeature(127);
	}

	@Override
	public String buildLayoutHTML() {

		StringBuilder sbHtml=new StringBuilder();
		sbHtml.append(buildDesktopHeader());
		sbHtml.append(buildMobileHeader());
		buildCompleteHTML(sbHtml);		
		return sbHtml.toString();
	}

	private void buildCompleteHTML(StringBuilder sbHtml) {
		String header="<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div>";
		String footer="</div>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		sbHtml.insert(0, header);
		
		sbHtml.append(footer);
	}

	private String buildMobileHeader() {
		
		return "<!-- HEADER MOBILE-->\r\n" + 
				"<header class=\"header-mobile header-mobile-2 d-block d-lg-none\">\r\n" + 
				"	<div class=\"header-mobile__bar\">\r\n" + 
				"		<div class=\"container-fluid\">\r\n" + 
				"			<div class=\"header-mobile-inner\">\r\n" + 
				"				<a class=\"logo\" href=\"index.html\">\r\n" + 
				"					<img src=\"images/icon/logo-white.png\" alt=\"CoolAdmin\" />\r\n" + 
				"				</a>\r\n" + 
				"				<button class=\"hamburger hamburger--slider\" type=\"button\">\r\n" + 
				"					<span class=\"hamburger-box\">\r\n" + 
				"						<span class=\"hamburger-inner\"></span>\r\n" + 
				"					</span>\r\n" + 
				"				</button>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	<nav class=\"navbar-mobile\">\r\n" + 
				"		<div class=\"container-fluid\">\r\n" + 
				"			<ul class=\"navbar-mobile__list list-unstyled\">\r\n" + 
				"				<li class=\"has-sub\">\r\n" + 
				"					<a class=\"js-arrow\" href=\"#\">\r\n" + 
				"						<i class=\"fas fa-tachometer-alt\"></i>Dashboard</a>\r\n" + 
				"					<ul class=\"navbar-mobile-sub__list list-unstyled js-sub-list\">\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"index.html\">Dashboard 1</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"index2.html\">Dashboard 2</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"index3.html\">Dashboard 3</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"index4.html\">Dashboard 4</a>\r\n" + 
				"						</li>\r\n" + 
				"					</ul>\r\n" + 
				"				</li>\r\n" + 
				"				<li>\r\n" + 
				"					<a href=\"chart.html\">\r\n" + 
				"						<i class=\"fas fa-chart-bar\"></i>Charts</a>\r\n" + 
				"				</li>\r\n" + 
				"				<li>\r\n" + 
				"					<a href=\"table.html\">\r\n" + 
				"						<i class=\"fas fa-table\"></i>Tables</a>\r\n" + 
				"				</li>\r\n" + 
				"				<li>\r\n" + 
				"					<a href=\"form.html\">\r\n" + 
				"						<i class=\"far fa-check-square\"></i>Forms</a>\r\n" + 
				"				</li>\r\n" + 
				"				<li>\r\n" + 
				"					<a href=\"#\">\r\n" + 
				"						<i class=\"fas fa-calendar-alt\"></i>Calendar</a>\r\n" + 
				"				</li>\r\n" + 
				"				<li>\r\n" + 
				"					<a href=\"map.html\">\r\n" + 
				"						<i class=\"fas fa-map-marker-alt\"></i>Maps</a>\r\n" + 
				"				</li>\r\n" + 
				"				<li class=\"has-sub\">\r\n" + 
				"					<a class=\"js-arrow\" href=\"#\">\r\n" + 
				"						<i class=\"fas fa-copy\"></i>Pages</a>\r\n" + 
				"					<ul class=\"navbar-mobile-sub__list list-unstyled js-sub-list\">\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"login.html\">Login</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"register.html\">Register</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"forget-pass.html\">Forget Password</a>\r\n" + 
				"						</li>\r\n" + 
				"					</ul>\r\n" + 
				"				</li>\r\n" + 
				"				<li class=\"has-sub\">\r\n" + 
				"					<a class=\"js-arrow\" href=\"#\">\r\n" + 
				"						<i class=\"fas fa-desktop\"></i>UI Elements</a>\r\n" + 
				"					<ul class=\"navbar-mobile-sub__list list-unstyled js-sub-list\">\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"button.html\">Button</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"badge.html\">Badges</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"tab.html\">Tabs</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"card.html\">Cards</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"alert.html\">Alerts</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"progress-bar.html\">Progress Bars</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"modal.html\">Modals</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"switch.html\">Switchs</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"grid.html\">Grids</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"fontawesome.html\">Fontawesome Icon</a>\r\n" + 
				"						</li>\r\n" + 
				"						<li>\r\n" + 
				"							<a href=\"typo.html\">Typography</a>\r\n" + 
				"						</li>\r\n" + 
				"					</ul>\r\n" + 
				"				</li>\r\n" + 
				"			</ul>\r\n" + 
				"		</div>\r\n" + 
				"	</nav>\r\n" + 
				"</header>\r\n" + 
				"<div class=\"sub-header-mobile-2 d-block d-lg-none\">\r\n" + 
				"	<div class=\"header__tool\">\r\n" + 
				"		<div class=\"header-button-item has-noti js-item-menu\">\r\n" + 
				"			<i class=\"zmdi zmdi-notifications\"></i>\r\n" + 
				"			<div class=\"notifi-dropdown notifi-dropdown--no-bor js-dropdown\">\r\n" + 
				"				<div class=\"notifi__title\">\r\n" + 
				"					<p>You have 3 Notifications</p>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"notifi__item\">\r\n" + 
				"					<div class=\"bg-c1 img-cir img-40\">\r\n" + 
				"						<i class=\"zmdi zmdi-email-open\"></i>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"content\">\r\n" + 
				"						<p>You got a email notification</p>\r\n" + 
				"						<span class=\"date\">April 12, 2018 06:50</span>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"notifi__item\">\r\n" + 
				"					<div class=\"bg-c2 img-cir img-40\">\r\n" + 
				"						<i class=\"zmdi zmdi-account-box\"></i>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"content\">\r\n" + 
				"						<p>Your account has been blocked</p>\r\n" + 
				"						<span class=\"date\">April 12, 2018 06:50</span>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"notifi__item\">\r\n" + 
				"					<div class=\"bg-c3 img-cir img-40\">\r\n" + 
				"						<i class=\"zmdi zmdi-file-text\"></i>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"content\">\r\n" + 
				"						<p>You got a new file</p>\r\n" + 
				"						<span class=\"date\">April 12, 2018 06:50</span>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"notifi__footer\">\r\n" + 
				"					<a href=\"#\">All notifications</a>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"header-button-item js-item-menu\">\r\n" + 
				"			<i class=\"zmdi zmdi-settings\"></i>\r\n" + 
				"			<div class=\"setting-dropdown js-dropdown\">\r\n" + 
				"				<div class=\"account-dropdown__body\">\r\n" + 
				"					<div class=\"account-dropdown__item\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"zmdi zmdi-account\"></i>Account</a>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"account-dropdown__item\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"zmdi zmdi-settings\"></i>Setting</a>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"account-dropdown__item\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"zmdi zmdi-money-box\"></i>Billing</a>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"account-dropdown__body\">\r\n" + 
				"					<div class=\"account-dropdown__item\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"zmdi zmdi-globe\"></i>Language</a>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"account-dropdown__item\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"zmdi zmdi-pin\"></i>Location</a>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"account-dropdown__item\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"zmdi zmdi-email\"></i>Email</a>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"account-dropdown__item\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"zmdi zmdi-notifications\"></i>Notifications</a>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"account-wrap\">\r\n" + 
				"			<div class=\"account-item account-item--style2 clearfix js-item-menu\">\r\n" + 
				"				<div class=\"image\">\r\n" + 
				"					<img src=\"images/icon/avatar-01.jpg\" alt=\"John Doe\" />\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"content\">\r\n" + 
				"					<a class=\"js-acc-btn\" href=\"#\">john doe</a>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"account-dropdown js-dropdown\">\r\n" + 
				"					<div class=\"info clearfix\">\r\n" + 
				"						<div class=\"image\">\r\n" + 
				"							<a href=\"#\">\r\n" + 
				"								<img src=\"images/icon/avatar-01.jpg\" alt=\"John Doe\" />\r\n" + 
				"							</a>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"content\">\r\n" + 
				"							<h5 class=\"name\">\r\n" + 
				"								<a href=\"#\">john doe</a>\r\n" + 
				"							</h5>\r\n" + 
				"							<span class=\"email\">johndoe@example.com</span>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"account-dropdown__body\">\r\n" + 
				"						<div class=\"account-dropdown__item\">\r\n" + 
				"							<a href=\"#\">\r\n" + 
				"								<i class=\"zmdi zmdi-account\"></i>Account</a>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"account-dropdown__item\">\r\n" + 
				"							<a href=\"#\">\r\n" + 
				"								<i class=\"zmdi zmdi-settings\"></i>Setting</a>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"account-dropdown__item\">\r\n" + 
				"							<a href=\"#\">\r\n" + 
				"								<i class=\"zmdi zmdi-money-box\"></i>Billing</a>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"account-dropdown__footer\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"zmdi zmdi-power\"></i>Logout</a>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"</div>";
	}

	private String buildDesktopHeader() {
		String s="<header class=\"header-desktop3 d-none d-lg-block\">\r\n" + 
				"	<div class=\"section__content section__content--p35\">\r\n" + 
				"		<div class=\"header3-wrap\">\r\n" + 
				"			<div class=\"header__logo\">\r\n" + 
				"				<a href=\"#\">\r\n" + 
				"					<img src=\"images/icon/logo-white.png\" alt=\"System Name\" />\r\n" + 
				"				</a>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"header__navbar\">\r\n" + 
				"				<ul class=\"list-unstyled\">\r\n" + 
				"					<li class=\"has-sub\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"fas fa-tachometer-alt\"></i>Dashboard\r\n" + 
				"							<span class=\"bot-line\"></span>\r\n" + 
				"						</a>\r\n" + 
				"						<ul class=\"header3-sub-list list-unstyled\">\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"index.html\">Dashboard 1</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"index2.html\">Dashboard 2</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"index3.html\">Dashboard 3</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"index4.html\">Dashboard 4</a>\r\n" + 
				"							</li>\r\n" + 
				"						</ul>\r\n" + 
				"					</li>\r\n" + 
				"					<li>\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"fas fa-shopping-basket\"></i>\r\n" + 
				"							<span class=\"bot-line\"></span>eCommerce</a>\r\n" + 
				"					</li>\r\n" + 
				"					<li>\r\n" + 
				"						<a href=\"table.html\">\r\n" + 
				"							<i class=\"fas fa-trophy\"></i>\r\n" + 
				"							<span class=\"bot-line\"></span>Features</a>\r\n" + 
				"					</li>\r\n" + 
				"					<li class=\"has-sub\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"fas fa-copy\"></i>\r\n" + 
				"							<span class=\"bot-line\"></span>Pages</a>\r\n" + 
				"						<ul class=\"header3-sub-list list-unstyled\">\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"login.html\">Login</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"register.html\">Register</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"forget-pass.html\">Forget Password</a>\r\n" + 
				"							</li>\r\n" + 
				"						</ul>\r\n" + 
				"					</li>\r\n" + 
				"					<li class=\"has-sub\">\r\n" + 
				"						<a href=\"#\">\r\n" + 
				"							<i class=\"fas fa-desktop\"></i>\r\n" + 
				"							<span class=\"bot-line\"></span>UI Elements</a>\r\n" + 
				"						<ul class=\"header3-sub-list list-unstyled\">\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"button.html\">Button</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"badge.html\">Badges</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"tab.html\">Tabs</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"card.html\">Cards</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"alert.html\">Alerts</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"progress-bar.html\">Progress Bars</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"modal.html\">Modals</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"switch.html\">Switchs</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"grid.html\">Grids</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"fontawesome.html\">FontAwesome</a>\r\n" + 
				"							</li>\r\n" + 
				"							<li>\r\n" + 
				"								<a href=\"typo.html\">Typography</a>\r\n" + 
				"							</li>\r\n" + 
				"						</ul>\r\n" + 
				"					</li>\r\n" + 
				"				</ul>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"header__tool\">\r\n" + 
				"				<div class=\"header-button-item has-noti js-item-menu\">\r\n" + 
				"					<i class=\"zmdi zmdi-notifications\"></i>\r\n" + 
				"					<div class=\"notifi-dropdown notifi-dropdown--no-bor js-dropdown\">\r\n" + 
				"						<div class=\"notifi__title\">\r\n" + 
				"							<p>You have 3 Notifications</p>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"notifi__item\">\r\n" + 
				"							<div class=\"bg-c1 img-cir img-40\">\r\n" + 
				"								<i class=\"zmdi zmdi-email-open\"></i>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"content\">\r\n" + 
				"								<p>You got a email notification</p>\r\n" + 
				"								<span class=\"date\">April 12, 2018 06:50</span>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"notifi__item\">\r\n" + 
				"							<div class=\"bg-c2 img-cir img-40\">\r\n" + 
				"								<i class=\"zmdi zmdi-account-box\"></i>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"content\">\r\n" + 
				"								<p>Your account has been blocked</p>\r\n" + 
				"								<span class=\"date\">April 12, 2018 06:50</span>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"notifi__item\">\r\n" + 
				"							<div class=\"bg-c3 img-cir img-40\">\r\n" + 
				"								<i class=\"zmdi zmdi-file-text\"></i>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"content\">\r\n" + 
				"								<p>You got a new file</p>\r\n" + 
				"								<span class=\"date\">April 12, 2018 06:50</span>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"notifi__footer\">\r\n" + 
				"							<a href=\"#\">All notifications</a>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"header-button-item js-item-menu\">\r\n" + 
				"					<i class=\"zmdi zmdi-settings\"></i>\r\n" + 
				"					<div class=\"setting-dropdown js-dropdown\">\r\n" + 
				"						<div class=\"account-dropdown__body\">\r\n" + 
				"							<div class=\"account-dropdown__item\">\r\n" + 
				"								<a href=\"#\">\r\n" + 
				"									<i class=\"zmdi zmdi-account\"></i>Account</a>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"account-dropdown__item\">\r\n" + 
				"								<a href=\"#\">\r\n" + 
				"									<i class=\"zmdi zmdi-settings\"></i>Setting</a>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"account-dropdown__item\">\r\n" + 
				"								<a href=\"#\">\r\n" + 
				"									<i class=\"zmdi zmdi-money-box\"></i>Billing</a>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"account-dropdown__body\">\r\n" + 
				"							<div class=\"account-dropdown__item\">\r\n" + 
				"								<a href=\"#\">\r\n" + 
				"									<i class=\"zmdi zmdi-globe\"></i>Language</a>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"account-dropdown__item\">\r\n" + 
				"								<a href=\"#\">\r\n" + 
				"									<i class=\"zmdi zmdi-pin\"></i>Location</a>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"account-dropdown__item\">\r\n" + 
				"								<a href=\"#\">\r\n" + 
				"									<i class=\"zmdi zmdi-email\"></i>Email</a>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"account-dropdown__item\">\r\n" + 
				"								<a href=\"#\">\r\n" + 
				"									<i class=\"zmdi zmdi-notifications\"></i>Notifications</a>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"account-wrap\">\r\n" + 
				"					<div class=\"account-item account-item--style2 clearfix js-item-menu\">\r\n" + 
				"						<div class=\"image\">\r\n" + 
				"							<img src=\"images/icon/avatar-01.jpg\" alt=\"John Doe\" />\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"content\">\r\n" + 
				"							<a class=\"js-acc-btn\" href=\"#\">john doe</a>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"account-dropdown js-dropdown\">\r\n" + 
				"							<div class=\"info clearfix\">\r\n" + 
				"								<div class=\"image\">\r\n" + 
				"									<a href=\"#\">\r\n" + 
				"										<img src=\"images/icon/avatar-01.jpg\" alt=\"John Doe\" />\r\n" + 
				"									</a>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"content\">\r\n" + 
				"									<h5 class=\"name\">\r\n" + 
				"										<a href=\"#\">john doe</a>\r\n" + 
				"									</h5>\r\n" + 
				"									<span class=\"email\">johndoe@example.com</span>\r\n" + 
				"								</div>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"account-dropdown__body\">\r\n" + 
				"								<div class=\"account-dropdown__item\">\r\n" + 
				"									<a href=\"#\">\r\n" + 
				"										<i class=\"zmdi zmdi-account\"></i>Account</a>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"account-dropdown__item\">\r\n" + 
				"									<a href=\"#\">\r\n" + 
				"										<i class=\"zmdi zmdi-settings\"></i>Setting</a>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"account-dropdown__item\">\r\n" + 
				"									<a href=\"#\">\r\n" + 
				"										<i class=\"zmdi zmdi-money-box\"></i>Billing</a>\r\n" + 
				"								</div>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"account-dropdown__footer\">\r\n" + 
				"								<a href=\"#\">\r\n" + 
				"									<i class=\"zmdi zmdi-power\"></i>Logout</a>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"</header>";
		return s;		
	}


}
