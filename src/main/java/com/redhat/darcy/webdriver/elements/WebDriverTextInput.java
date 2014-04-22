/*
 Copyright 2014 Red Hat, Inc. and/or its affiliates.

 This file is part of darcy-webdriver.

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.redhat.darcy.webdriver.elements;

import com.redhat.darcy.ui.elements.TextInput;
import com.redhat.darcy.webdriver.ElementFinder;

import org.openqa.selenium.WebElement;

public class WebDriverTextInput extends WebDriverElement implements TextInput {
    public WebDriverTextInput(WebElement source, ElementFinder finder) {
        super(source, finder);
    }
    
    @Override
    public void clearAndType(String stringToType) {
        click();
        me.clear();
        me.sendKeys(stringToType);
        // TODO: send TAB key to trigger blur events
    }
    
    @Override
    public void sendKeys(CharSequence... keysToSend) {
        click();
        me.sendKeys(keysToSend);
    }
    
    @Override
    public String readValue() {
        return me.getAttribute("value");
    }
    
    @Override
    public void click() {
        me.click();
    }

    @Override
    public void clear() {
        me.clear();
    }

    @Override
    public boolean isEnabled() {
        return me.isEnabled();
    }
}
