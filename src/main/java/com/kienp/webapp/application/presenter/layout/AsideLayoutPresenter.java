package com.kienp.webapp.application.presenter.layout;

import java.util.List;

import org.springframework.stereotype.Component;

@Component(value="AsideLayoutPresenter")
public class AsideLayoutPresenter implements LayoutPresenter {

	@Override
	public List<String> getListFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String buildLayoutHTML() {
		StringBuilder sbHtml=new StringBuilder();
		sbHtml.append(buildMenuSideBar());
		sbHtml.append(buildDesktopHeader());		
		//sbHtml.append(buildMobileHeader());
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
	
	private String buildMenuSideBar() {
		return " <aside class=\"menu-sidebar d-none d-lg-block\">\r\n" + 
				"            <div class=\"logo\">\r\n" + 
				"                <a href=\"#\">\r\n" + 
				"                    <img src=\"images/icon/logo.png\" alt=\"Cool Admin\" />\r\n" + 
				"                </a>\r\n" + 
				"            </div>\r\n" + 
				"            <div class=\"menu-sidebar__content js-scrollbar1\">\r\n" + 
				"                <nav class=\"navbar-sidebar\">\r\n" + 
				"                    <ul class=\"list-unstyled navbar__list\">\r\n" + 
				"                        <li class=\"active has-sub\">\r\n" + 
				"                            <a class=\"js-arrow\" href=\"#\">\r\n" + 
				"                                <i class=\"fas fa-tachometer-alt\"></i>Dashboard</a>\r\n" + 
				"                            <ul class=\"list-unstyled navbar__sub-list js-sub-list\">\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"index.html\">Dashboard 1</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"index2.html\">Dashboard 2</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"index3.html\">Dashboard 3</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"index4.html\">Dashboard 4</a>\r\n" + 
				"                                </li>\r\n" + 
				"                            </ul>\r\n" + 
				"                        </li>\r\n" + 
				"                        <li>\r\n" + 
				"                            <a href=\"chart.html\">\r\n" + 
				"                                <i class=\"fas fa-chart-bar\"></i>Charts</a>\r\n" + 
				"                        </li>\r\n" + 
				"                        <li>\r\n" + 
				"                            <a href=\"table.html\">\r\n" + 
				"                                <i class=\"fas fa-table\"></i>Tables</a>\r\n" + 
				"                        </li>\r\n" + 
				"                        <li>\r\n" + 
				"                            <a href=\"form.html\">\r\n" + 
				"                                <i class=\"far fa-check-square\"></i>Forms</a>\r\n" + 
				"                        </li>\r\n" + 
				"                        <li>\r\n" + 
				"                            <a href=\"#\">\r\n" + 
				"                                <i class=\"fas fa-calendar-alt\"></i>Calendar</a>\r\n" + 
				"                        </li>\r\n" + 
				"                        <li>\r\n" + 
				"                            <a href=\"map.html\">\r\n" + 
				"                                <i class=\"fas fa-map-marker-alt\"></i>Maps</a>\r\n" + 
				"                        </li>\r\n" + 
				"                        <li class=\"has-sub\">\r\n" + 
				"                            <a class=\"js-arrow\" href=\"#\">\r\n" + 
				"                                <i class=\"fas fa-copy\"></i>Pages</a>\r\n" + 
				"                            <ul class=\"list-unstyled navbar__sub-list js-sub-list\">\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"login.html\">Login</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"register.html\">Register</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"forget-pass.html\">Forget Password</a>\r\n" + 
				"                                </li>\r\n" + 
				"                            </ul>\r\n" + 
				"                        </li>\r\n" + 
				"                        <li class=\"has-sub\">\r\n" + 
				"                            <a class=\"js-arrow\" href=\"#\">\r\n" + 
				"                                <i class=\"fas fa-desktop\"></i>UI Elements</a>\r\n" + 
				"                            <ul class=\"list-unstyled navbar__sub-list js-sub-list\">\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"button.html\">Button</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"badge.html\">Badges</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"tab.html\">Tabs</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"card.html\">Cards</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"alert.html\">Alerts</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"progress-bar.html\">Progress Bars</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"modal.html\">Modals</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"switch.html\">Switchs</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"grid.html\">Grids</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"fontawesome.html\">Fontawesome Icon</a>\r\n" + 
				"                                </li>\r\n" + 
				"                                <li>\r\n" + 
				"                                    <a href=\"typo.html\">Typography</a>\r\n" + 
				"                                </li>\r\n" + 
				"                            </ul>\r\n" + 
				"                        </li>\r\n" + 
				"                    </ul>\r\n" + 
				"                </nav>\r\n" + 
				"            </div>\r\n" + 
				"        </aside>";
	}

	private String buildMobileHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	private String buildDesktopHeader() {
		// TODO Auto-generated method stub
		return "            <header class=\"header-desktop\">\r\n" + 
				"                <div class=\"section__content section__content--p30\">\r\n" + 
				"                    <div class=\"container-fluid\">\r\n" + 
				"                        <div class=\"header-wrap\">\r\n" + 
				"                            <form class=\"form-header\" action=\"\" method=\"POST\">\r\n" + 
				"                                <input class=\"au-input au-input--xl\" type=\"text\" name=\"search\" placeholder=\"Search for datas &amp; reports...\" />\r\n" + 
				"                                <button class=\"au-btn--submit\" type=\"submit\">\r\n" + 
				"                                    <i class=\"zmdi zmdi-search\"></i>\r\n" + 
				"                                </button>\r\n" + 
				"                            </form>\r\n" + 
				"                            <div class=\"header-button\">\r\n" + 
				"                                <div class=\"noti-wrap\">\r\n" + 
				"                                    <div class=\"noti__item js-item-menu\">\r\n" + 
				"                                        <i class=\"zmdi zmdi-comment-more\"></i>\r\n" + 
				"                                        <span class=\"quantity\">1</span>\r\n" + 
				"                                        <div class=\"mess-dropdown js-dropdown\">\r\n" + 
				"                                            <div class=\"mess__title\">\r\n" + 
				"                                                <p>You have 2 news message</p>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"mess__item\">\r\n" + 
				"                                                <div class=\"image img-cir img-40\">\r\n" + 
				"                                                    <img src=\"images/icon/avatar-06.jpg\" alt=\"Michelle Moreno\" />\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"content\">\r\n" + 
				"                                                    <h6>Michelle Moreno</h6>\r\n" + 
				"                                                    <p>Have sent a photo</p>\r\n" + 
				"                                                    <span class=\"time\">3 min ago</span>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"mess__item\">\r\n" + 
				"                                                <div class=\"image img-cir img-40\">\r\n" + 
				"                                                    <img src=\"images/icon/avatar-04.jpg\" alt=\"Diane Myers\" />\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"content\">\r\n" + 
				"                                                    <h6>Diane Myers</h6>\r\n" + 
				"                                                    <p>You are now connected on message</p>\r\n" + 
				"                                                    <span class=\"time\">Yesterday</span>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"mess__footer\">\r\n" + 
				"                                                <a href=\"#\">View all messages</a>\r\n" + 
				"                                            </div>\r\n" + 
				"                                        </div>\r\n" + 
				"                                    </div>\r\n" + 
				"                                    <div class=\"noti__item js-item-menu\">\r\n" + 
				"                                        <i class=\"zmdi zmdi-email\"></i>\r\n" + 
				"                                        <span class=\"quantity\">1</span>\r\n" + 
				"                                        <div class=\"email-dropdown js-dropdown\">\r\n" + 
				"                                            <div class=\"email__title\">\r\n" + 
				"                                                <p>You have 3 New Emails</p>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"email__item\">\r\n" + 
				"                                                <div class=\"image img-cir img-40\">\r\n" + 
				"                                                    <img src=\"images/icon/avatar-06.jpg\" alt=\"Cynthia Harvey\" />\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"content\">\r\n" + 
				"                                                    <p>Meeting about new dashboard...</p>\r\n" + 
				"                                                    <span>Cynthia Harvey, 3 min ago</span>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"email__item\">\r\n" + 
				"                                                <div class=\"image img-cir img-40\">\r\n" + 
				"                                                    <img src=\"images/icon/avatar-05.jpg\" alt=\"Cynthia Harvey\" />\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"content\">\r\n" + 
				"                                                    <p>Meeting about new dashboard...</p>\r\n" + 
				"                                                    <span>Cynthia Harvey, Yesterday</span>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"email__item\">\r\n" + 
				"                                                <div class=\"image img-cir img-40\">\r\n" + 
				"                                                    <img src=\"images/icon/avatar-04.jpg\" alt=\"Cynthia Harvey\" />\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"content\">\r\n" + 
				"                                                    <p>Meeting about new dashboard...</p>\r\n" + 
				"                                                    <span>Cynthia Harvey, April 12,,2018</span>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"email__footer\">\r\n" + 
				"                                                <a href=\"#\">See all emails</a>\r\n" + 
				"                                            </div>\r\n" + 
				"                                        </div>\r\n" + 
				"                                    </div>\r\n" + 
				"                                    <div class=\"noti__item js-item-menu\">\r\n" + 
				"                                        <i class=\"zmdi zmdi-notifications\"></i>\r\n" + 
				"                                        <span class=\"quantity\">3</span>\r\n" + 
				"                                        <div class=\"notifi-dropdown js-dropdown\">\r\n" + 
				"                                            <div class=\"notifi__title\">\r\n" + 
				"                                                <p>You have 3 Notifications</p>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"notifi__item\">\r\n" + 
				"                                                <div class=\"bg-c1 img-cir img-40\">\r\n" + 
				"                                                    <i class=\"zmdi zmdi-email-open\"></i>\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"content\">\r\n" + 
				"                                                    <p>You got a email notification</p>\r\n" + 
				"                                                    <span class=\"date\">April 12, 2018 06:50</span>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"notifi__item\">\r\n" + 
				"                                                <div class=\"bg-c2 img-cir img-40\">\r\n" + 
				"                                                    <i class=\"zmdi zmdi-account-box\"></i>\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"content\">\r\n" + 
				"                                                    <p>Your account has been blocked</p>\r\n" + 
				"                                                    <span class=\"date\">April 12, 2018 06:50</span>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"notifi__item\">\r\n" + 
				"                                                <div class=\"bg-c3 img-cir img-40\">\r\n" + 
				"                                                    <i class=\"zmdi zmdi-file-text\"></i>\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"content\">\r\n" + 
				"                                                    <p>You got a new file</p>\r\n" + 
				"                                                    <span class=\"date\">April 12, 2018 06:50</span>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"notifi__footer\">\r\n" + 
				"                                                <a href=\"#\">All notifications</a>\r\n" + 
				"                                            </div>\r\n" + 
				"                                        </div>\r\n" + 
				"                                    </div>\r\n" + 
				"                                </div>\r\n" + 
				"                                <div class=\"account-wrap\">\r\n" + 
				"                                    <div class=\"account-item clearfix js-item-menu\">\r\n" + 
				"                                        <div class=\"image\">\r\n" + 
				"                                            <img src=\"images/icon/avatar-01.jpg\" alt=\"John Doe\" />\r\n" + 
				"                                        </div>\r\n" + 
				"                                        <div class=\"content\">\r\n" + 
				"                                            <a class=\"js-acc-btn\" href=\"#\">john doe</a>\r\n" + 
				"                                        </div>\r\n" + 
				"                                        <div class=\"account-dropdown js-dropdown\">\r\n" + 
				"                                            <div class=\"info clearfix\">\r\n" + 
				"                                                <div class=\"image\">\r\n" + 
				"                                                    <a href=\"#\">\r\n" + 
				"                                                        <img src=\"images/icon/avatar-01.jpg\" alt=\"John Doe\" />\r\n" + 
				"                                                    </a>\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"content\">\r\n" + 
				"                                                    <h5 class=\"name\">\r\n" + 
				"                                                        <a href=\"#\">john doe</a>\r\n" + 
				"                                                    </h5>\r\n" + 
				"                                                    <span class=\"email\">johndoe@example.com</span>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"account-dropdown__body\">\r\n" + 
				"                                                <div class=\"account-dropdown__item\">\r\n" + 
				"                                                    <a href=\"#\">\r\n" + 
				"                                                        <i class=\"zmdi zmdi-account\"></i>Account</a>\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"account-dropdown__item\">\r\n" + 
				"                                                    <a href=\"#\">\r\n" + 
				"                                                        <i class=\"zmdi zmdi-settings\"></i>Setting</a>\r\n" + 
				"                                                </div>\r\n" + 
				"                                                <div class=\"account-dropdown__item\">\r\n" + 
				"                                                    <a href=\"#\">\r\n" + 
				"                                                        <i class=\"zmdi zmdi-money-box\"></i>Billing</a>\r\n" + 
				"                                                </div>\r\n" + 
				"                                            </div>\r\n" + 
				"                                            <div class=\"account-dropdown__footer\">\r\n" + 
				"                                                <a href=\"#\">\r\n" + 
				"                                                    <i class=\"zmdi zmdi-power\"></i>Logout</a>\r\n" + 
				"                                            </div>\r\n" + 
				"                                        </div>\r\n" + 
				"                                    </div>\r\n" + 
				"                                </div>\r\n" + 
				"                            </div>\r\n" + 
				"                        </div>\r\n" + 
				"                    </div>\r\n" + 
				"                </div>\r\n" + 
				"            </header>";
	}

}
