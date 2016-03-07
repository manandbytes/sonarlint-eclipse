/*
 * SonarLint for Eclipse
 * Copyright (C) 2015-2016 SonarSource SA
 * sonarlint@sonarsource.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarlint.eclipse.ui.internal.server;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;
import org.sonarlint.eclipse.core.internal.server.IServer;
import org.sonarlint.eclipse.ui.internal.Messages;
import org.sonarlint.eclipse.ui.internal.SonarLintImages;
import org.sonarlint.eclipse.ui.internal.SonarLintUiPlugin;

/**
 * Server table label provider.
 */
public class ServerLabelProvider extends BaseCellLabelProvider {

  @Override
  public String getText(Object element) {
    if (element instanceof IServer) {
      IServer server = (IServer) element;
      return notNull(server.getName());
    }

    if (element == ServerContentProvider.INITIALIZING)
      return Messages.viewInitializing;

    if (element instanceof IWorkspaceRoot) {
      return Platform.getResourceString(SonarLintUiPlugin.getDefault().getBundle(), "%viewServers");
    }

    return "";
  }

  @Override
  public Image getImage(Object element) {
    if (element instanceof IServer) {
      return SonarLintImages.SONAR16_IMG;
    }
    return null;
  }

  protected String notNull(String s) {
    if (s == null)
      return "";
    return s;
  }

  @Override
  public Image getColumnImage(Object element, int index) {
    // TODO Left blank since the CNF doesn't support this
    return null;
  }

  @Override
  public String getColumnText(Object element, int index) {
    // TODO Left blank since the CNF doesn't support this
    return null;
  }

}
