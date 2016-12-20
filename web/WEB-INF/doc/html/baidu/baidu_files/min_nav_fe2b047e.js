F._setMod("nav");
F._fileMap({
    "/js/min_nav_11928a6a.js": ["config", "start/nav_start", "log/nav_all", "nav/nav_show", "nav/msgbox", "nav/nav_addproxy", "nav/nav_msg", "nav/nav_util", "nav/nav_str_manager", "nav/nav_direct_change"],
    "/js/nav_extend_ecdd44ff.js": ["nav/skeleton", "nav/dir_item", "nav/nav_addform", "nav/nav", "nav/nplus", "nav/nav_drag", "nav/dir_drag", "nav/nori", "nav/nori_drag", "nav/nav_data_controller", "nav/nav_item", "nav/nav_res_tip", "nav/open_res", "common/placeholder", "common/sug", "common/sug_layer", "common/name_sug", "common/url_sug", "nav/nav_nused", "nav/nav_used_del_tip"],
    "/css/nav_min_1e6fb18e.css": ["nav_init.css", "index_newuser.css", "skin.css", "skin_opacity.css"],
    "/css/nav_extend_c8a1e6e6.css": ["index_nav.css", "index_nav_addform.css", "add_nav_win_form.css", "index_nav_addform.css", "sug.css"],
    "/css/nav_guide_2501ad4f.css": ["nav_custom_guide.css", "nav_remind_tip.css", "nav_classify_tip.css", "nav_noclick_clean_tip.css", "nav_guide.css", "nav_res_tip.css", "nav_used_tip.css", "nav_used_extend_tip.css", "nav_used_del_tip.css", "nav_used_update_tip.css"],
    "/js/nav_tips_09f839d1.js": ["nav/nav_custom_tip", "nav/nav_clearguide", "nav/nav_classify_tip", "nav/nav_remind_tip", "nav/nav_guide_entrance", "nav/nav_noclick_clean_tip", "nav/nused_log", "nav/nav_used_tip", "nav/nav_used_extend_tip", "nav/nav_used_update_tip"],
    "/js/nav_rp_22f90dff.js": ["nav/nav_remind_tip"],
    "/js/new_user_e100f6e8.js": ["nav/new_user", "nav/add_layer", "nav/add_guide"]
});
F._defService("nav", {
    nav: "nav/nav_data_controller",
    navShow: "nav/nav_show",
    navSkeleton: "nav/skeleton",
    start: "start/nav_start",
    addProxy: "nav/nav_addproxy",
    navGuide: "nav/nav_guide_entrance"
});
F._firstScreenCSS = F._firstScreenCSS || [];
F._firstScreenCSS.push("/css/nav_min_1e6fb18e.css");
F.module("nav:start/nav_start", function (c, b, a) {
    b.run = function () {
        a.use("log/nav_all", function (e) {
            e.init()
        });
        var d = parseInt(s_session.userTips.emptyUserGuide);
        if (isNaN(d)) {
            d = 0
        }
        if (s_session.userIsNewSkined != "on" && (s_session.userNavEmpty == "1" || ((d > 0 && d < 7) || (d == 9)))) {
            a.use("nav/new_user", function (e) {
                e.init(d)
            })
        } else {
            if (s_session.bgUNE == "1") {
                a.use("nav/new_user", function (e) {
                    e.bindBgUNE()
                })
            }
        }
        a.use("nav/nav_show", function (e) {
            e.init(false)
        })
    }
});
F.module("nav:log/nav_all", function (c, b, a) {
    b.init = function () {
        F.addLog("nav:nav", {
            toggleEditMode: "0100300001",
            addBtnClick: "0100400001",
            log: "0100000001",
            navCleanShow: "0100600000",
            navCleanClick: "0100600001",
            navTipDisplay: "0100100000",
            changeNavView: "0101000001",
            rpShow: "0101100000",
            rpClick: "0101100001",
            navFromResShow: "0101400000",
            navFromResClick: "0101400001",
            ncTipShow: "0101300000",
            ncTipClick: "0101300001",
            closeBtnClick: "0101500001",
            changeTab: "0101600001",
            myWebUpdate: "0801000000",
            myWebUpdateClick: "0801000001",
            customThirdGuideShow: "0801700000",
            customThirdGuideClick: "0801700001",
            dirAddFormClick: "0101700001",
            navAddWinClick: "1600100001",
            navCleanKeyClick: "0101800001",
            navCleanKeyShow: "0101800000",
            navRpAddLayerShow: "0101900000",
            navRpSwitchTurn: "0101900001",
            newUserGuideShow: "0102100000",
            newUserGuideClick: "0102100001",
            newUserAddLayerAdd: "0102200001",
            ncfTipMainShow: "0102500000",
            ncfTipMainClick: "0102500001",
            navRenameOperate: "0100000002",
            guidePopupShow: "0100700000",
            guidePopupClick: "0100700001",
            packGuideClick: "0800300001",
            guideShown: "0000100000",
            guideClick: "0000100001",
            navNusedShow: "0102900000",
            navUsedGuideShow: "0102600000",
            navUsedGuideClick: "0102600001",
            navUsedSwitchTurn: "0102700001",
            btnChangeClick: "0102800001"
        })
    }
});
F.module("nav:nav/nav_show", function (a, c, j) {
    var b = j.base, f = true, d = true, g = b.g("s_mod_nav");

    function i(l, k) {
        if (g && g.style.display == "none" && l) {
            g.style.display = "";
            g.style.height = "";
            if (b.isIE) {
                baidu.dom.removeStyle(g, "filter")
            }
            k && k();
            j.fire("addNavModFromAddLayer")
        }
        if (f && g.style.display != "none") {
            if (l) {
                F.getService("superpage", "lzload", function (m) {
                    m.scanAndDoRender(b.g("s_mod_nav"))
                })
            }
            j.use("nav/nav_addproxy", function (m) {
                m.NavAddProxy.init();
                F.getService("msg", "idxNavMsg", function (n) {
                    n.init()
                });
                F.call("nav:nav/nav_direct_change", "init");
                b.on(b.g("s_main"), "mouseover", function (n) {
                    if (d) {
                        F.getService("superpage", "baseExtend");
                        j.use("nav/skeleton", function (o) {
                            o.skeleton.init()
                        });
                        F.call("nav:nav/nav_res_tip", "init");
                        d = false
                    }
                });
                f = false
            })
        } else {
            if (f) {
                b.on("s_main", "mouseover", function (m) {
                    F.getService("superpage", "baseExtend")
                })
            }
        }
    }

    function e(k) {
        j.listen("nav/nav_addproxy", "deleteNav", k)
    }

    function h() {
        j.fire("deleteNavMod")
    }

    c.init = i;
    c.proceDelNav = e;
    c.onDeleteEnd = h
});
F.module("nav:nav/msgbox", function (d, c, b) {
    var e = b.base;
    var a = null;
    c.MsgBox = e.Class.create(function (g) {
        var m = this, l = [], h, i = [], n = null;
        m.bindDoms = [];
        m._name = "MsgBox";
        m.position = "";
        m.className = "bm-mark";
        m.html = "";
        m.tipConf = null;
        m.bindTip = false;
        var k = null;
        m.getNavItemAllData = function (q, r) {
            h = q;
            F.getService("msg", "idxNavMsg", function (s) {
                s.getMarkConfig(q, function (v, u, t) {
                    m.position = v;
                    m.html = u;
                    if (r) {
                        r(t)
                    }
                    return t
                })
            })
        };
        m.getHtml = function (q) {
            getNavItemAllData(q);
            return m.html
        };
        m.init = function (s) {
            n = s;
            var q = e.q("s-nav-name", n)[0];
            l.push(q);
            var r = e.q("bm-mark", n)[0];
            i.push(r);
            m.bindDoms.push((m.position == "beforeEnd" ? q : r))
        };
        m.getEntity = function () {
            return n
        };
        m.showTip = function () {
            m.initMsgTip();
            if (m.position == "beforeEnd" && m.tipConf && m.tipConf.tipHtml) {
                b.use("nav/nav_data_controller", function (r) {
                    var q = r.ndc.getNavParams(h, "tipDisplay");
                    F.getService("msg", "dataServer", function (t) {
                        var s = t.getData(h);
                        if (s) {
                            q.tipType = s.tipType;
                            if (s.tipType == "video") {
                                q.videoUrl = s.msgDetail && s.msgDetail.curObjUrl;
                                q.finish = s.msgDetail && s.msgDetail.finish
                            } else {
                                q.bindStatus = s.bindStatus;
                                q.bindType = s.bindType
                            }
                        }
                        b.fire("navTipDisplay", q)
                    })
                })
            }
        };
        m.initMsgTip = function (q) {
            F.getService("msg", "idxNavMsg", function (r) {
                r.getMsgConfig(h, function (s) {
                    m.tipConf = s;
                    j(m.tipConf);
                    p();
                    q && q(m)
                })
            })
        };
        function j(q) {
            o(q);
            f(q)
        }

        function p() {
            b.use("nav/nav_msg", function (q) {
                if (q.navMsg.tips && q.navMsg.tips.Tip) {
                    q.navMsg.tips.Tip.innerHTML = m.tipConf.tipHtml
                }
            })
        }

        function o(q) {
            if (q.markClick) {
                b.use("nav/nav_addproxy", function (r) {
                    k = r.NavAddProxy.getNav(h);
                    if (k) {
                        e.forEach(i, function (s) {
                            s.onclick = function () {
                                return q.markClick(k)
                            }
                        })
                    } else {
                        b.use("nav/nav_data_controller", function (s) {
                            k = s.ndc.getNavById(h);
                            e.forEach(i, function (t) {
                                t.onclick = function () {
                                    return q.markClick(k)
                                }
                            })
                        })
                    }
                })
            }
        }

        function f(q) {
            if (q.navClick) {
                b.use("nav/nav_addproxy", function (r) {
                    k = r.NavAddProxy.getNav(h);
                    if (k) {
                        e.forEach(l, function (s) {
                            s.onclick = function () {
                                var t = q.navClick(k);
                                return t
                            }
                        })
                    } else {
                        b.use("nav/nav_data_controller", function (s) {
                            k = s.ndc.getNavById(h);
                            e.forEach(l, function (t) {
                                t.onclick = function () {
                                    var u = q.navClick(k);
                                    return u
                                }
                            })
                        })
                    }
                })
            }
        }
    })
});
F.module("nav:nav/nav_addproxy", function (c, b, a) {
    c("nav_init.css");
    var d = a.base;
    var e = c("nav/nav_str_manager");
    var g = e.navNameHandler;
    var h = c("nav/nav_util").navUtil;
    var f = d.Class.create(function () {
        var B = this, s = null;
        B.canClick = true;
        var x = d.g("s_mod_nav_b_settings"), p = d.g("s_mod_nav_add"), q = d.g("s_mod_nav"), n = d.g("s_ndirect_area"), k = false;
        (function A(J) {
            var D = J.data;
            var H = {}, G = [], I = {}, E = {}, C = [];
            d.forEach(D, function (K) {
                G.push(K.dirId);
                E[K.dirId] = [];
                I[K.dirId] = K.dirName;
                H[K.dirId] = {};
                d.forEach(K.navs, function (L) {
                    L.url = decodeURIComponent(L.url);
                    L.dirId = K.dirId;
                    E[K.dirId].push(L.id);
                    H[K.dirId][L.id] = L;
                    if (L.clean) {
                        C.push(L)
                    }
                })
            });
            B.navData = {dirNames: I, seqDirs: G, seqNavs: E, navs: H, data: D};
            B.isEmptyNavUser = (s_session.userNavEmpty == "1");
            B.showCommTab = J.showCommTab == "on" ? true : false;
            B.defaultDirId = J.defaultDirId;
            B.toCleanNavs = C
        })(d.jsonParse(d.trim(d.g("nav_data").innerHTML)));
        B.getNav = function (H) {
            if (!B.navData) {
                return null
            }
            var G = B.navData.seqDirs;
            var E;
            for (var D = 0, C = G.length; D < C; D++) {
                E = B.navData.navs[G[D]][H];
                if (E) {
                    break
                }
            }
            return E
        };
        B.removeNav = function (G) {
            var H = B.getNav(G);
            if (!H) {
                return
            }
            var D = H.dirId, C;
            var E = {cmd: "del_nav", ids: G, dirIds: D};
            d.post(s_domain.baseuri + "/nplus/submit/nav", E, function (I) {
                if (I.errNo == 0) {
                    C = d.array.indexOf(B.navData.seqNavs[D], G);
                    if (C >= 0) {
                        B.navData.seqNavs[D].splice(C, 1)
                    }
                    delete B.navData.navs[D][G];
                    d.remove(d.g("s_nav_" + G))
                }
            })
        };
        function u() {
            if (!k) {
                a.use("nav/nav_msg", function (C) {
                    C.navMsg.init()
                });
                v();
                z();
                l();
                r();
                i();
                s = s_session.userProp.isNplus;
                if (s) {
                    m()
                } else {
                    j()
                }
                k = true
            }
        }

        function v() {
            if (d.isFirefox < 7 || d.isChrome) {
                var D = d.q("s-nav-name", d.g("s_nav_area"));
                s = s_session.userProp.isNplus;
                d.forEach(D, function (G) {
                    var E = G.getElementsByTagName("em")[0];
                    if (h.isClassify()) {
                        g(E, E.innerHTML, 98)
                    } else {
                        g(E, E.innerHTML, 120)
                    }
                });
                D = d.q("s-nav-name", n);
                d.forEach(D, function (G) {
                    var E = G.getElementsByTagName("em")[0];
                    g(E, E.innerHTML, 98)
                });
                if (h.isNplus()) {
                    var C = d.q("s-ncf-name-link", d.g("s_nav_area"));
                    d.forEach(C, function (E) {
                        h.handleDirName(E)
                    })
                }
            }
            if (d.isChrome && d.g("s_nav_area")) {
                d.addClass(d.g("s_nav_area"), "chrome")
            }
        }

        function i() {
            var C = d.q("s-nav-name", d.g("s_nav_area"));
            d.forEach(C, function (D) {
                d.on(D, "mouseover", function () {
                    d.addClass(this, "mouseover")
                });
                d.on(D, "mouseout", function () {
                    d.removeClass(this, "mouseover")
                })
            })
        }

        function z() {
            var C = d.g("s_mod_nav_close");
            if (C) {
                d.on(C, "click", function (D) {
                    if (q && q.style.display != "none") {
                        a.fire("deleteNav", {id: 2400})
                    }
                })
            }
        }

        function m() {
            var C = d.q("s-ncf-name", q), D = null;
            d.forEach(C, function (E) {
                D = E.getElementsByTagName("a")[0];
                d.on(D, "mouseover", function () {
                    d.addClass(this, "mouseover")
                });
                d.on(D, "mouseout", function () {
                    d.removeClass(this, "mouseover")
                })
            })
        }

        function l() {
            T.on(p, "mouseover", function (C) {
                p.className = "s-shortcut-add-hover"
            });
            T.on(p, "mouseout", function (C) {
                p.className = "s-shortcut-add"
            })
        }

        function r() {
            if (d.g("s_shortcut_empty_tip")) {
                T.on(d.g("s_shortcut_empty_tip"), "click", function () {
                    h.openAddWin(s_session.userProp.isNplus)
                })
            }
        }

        function j() {
            if (d.g("s_nori_add_btn")) {
                T.on(d.g("s_nori_add_btn"), "click", function () {
                    h.openAddWin(false);
                    a.fire("addBtnClick", {
                        navTab: h.getCurTab(),
                        isCustomDir: s_session.userTips.isCustomDir ? "on" : "off",
                        refer: "below",
                        guideType: B.isEmptyNavUser ? "emptyNavGuide" : "noneGuide",
                        isCleanedUser: s_session.userTips.navNoClickClean == "cleaned"
                    })
                })
            }
        }

        function t() {
            var C = d.g("s_mod_nav_titleBar");
            d.on(C, "mouseover", function () {
                d.addClass(d.g("s_mod_nav_b_settings"), "s-mod-set-view-hover");
                d.addClass(d.g("s_mod_nav_add"), "s-shortcut-add-hover")
            });
            d.on(C, "mouseout", function () {
                d.removeClass(d.g("s_mod_nav_b_settings"), "s-mod-set-view-hover");
                d.removeClass(d.g("s_mod_nav_add"), "s-shortcut-add-hover")
            })
        }

        var w = function (C) {
            a.use("nav/nav", function (D) {
                D.nav.addRawNav(C)
            })
        };
        var y = function () {
            F.call("nav:nav/nav", "show")
        };
        var o = function () {
            F.call("nav:nav/nav", "hide")
        };
        B.show = y;
        B.hide = o;
        B.init = u;
        B.addRawNav = w
    });
    b.NavAddProxy = new f();
    b.navData = b.NavAddProxy.navData;
    b.isEmptyNavUser = b.NavAddProxy.isEmptyNavUser;
    b.defaultDirId = b.NavAddProxy.defaultDirId;
    b.showCommTab = b.NavAddProxy.showCommTab;
    b.addRawNav = b.NavAddProxy.addRawNav
});
F.module("nav:nav/nav_msg", function (c, f, i) {
    var e = i.base;
    var d = c("nav/msgbox").MsgBox;
    var b = c("nav/nav_str_manager");
    var g = b.navNameHandler;
    var h = c("nav/nav_util").navUtil;
    var a = e.Class.create(function () {
        var s = this, p = null, n = false, l = false, t = false, o = {commonusedweb: "nused", myweb: "nav"};
        s.needUpdateMsg = true;
        s.tips = null;
        s.msgBoxesData = {};
        var z = function () {
            if (!n) {
                i.listen("msg:msg", "dataUpdated", function (A) {
                    s.addMsgDone = false;
                    var B = A.relatedNavs;
                    if (B.length > 0) {
                        e.forEach(B, function (C) {
                            m(C)
                        })
                    }
                });
                n = true
            }
        };

        function m(A) {
            p = new d(s);
            p.getNavItemAllData(A, x)
        }

        var r = function (A) {
            if (e.g("s_ndirect_area") && !e.hasClass(e.g("s_ndirect_area"), "unshown")) {
                if (e.g("s_nused_" + A)) {
                    return e.g("s_nused_" + A)
                } else {
                    return e.g("s_nadd_" + A)
                }
            } else {
                return e.g("s_nav_" + A)
            }
        };

        function x(A) {
            e.forEach(["nav", "nused", "nadd"], function (D) {
                var C = e.g("s_" + D + "_" + A.navId);
                if (C) {
                    w(C, A.navId)
                }
            });
            var B = r(A.navId);
            if (B) {
                y(B, A)
            }
        }

        function y(E, J) {
            if (J.reBind != "1") {
                return false
            }
            var I = 30 * 86400;
            var A = [];
            var M = s_session.userTips.msgWeiboRebindKey || "";
            if (M && M.indexOf("_") > 0) {
                A = M.split("_")
            }
            if (A[1] && parseInt(A[1]) > 1) {
                return false
            } else {
                A[1] = A[1] ? parseInt(A[1]) : 0
            }
            var B = false;
            var L = A[0] ? parseInt(A[0]) : 0;
            if (window.sysTime - L >= I) {
                B = true
            }
            if (B) {
                var C = "s_nav_weiborebind_tip", K = e.g("s_mod_nav");
                var H = function (P) {
                    e.g(C) && e.remove(C);
                    var O = new Date().getTime() + "";
                    O = O.substr(0, 10);
                    var Q = A[1] + 1;
                    var N = O + "_" + Q;
                    F.getService("superpage", "userAttr", function (R) {
                        R.setAttr("msgWeiboRebindKey", N)
                    });
                    i.fire("guidePopupClick", {opType: P})
                };
                var G = function (N) {
                    N.bind({
                        bindType: "5",
                        dataType: "bind",
                        fullName: "新浪微博",
                        id: "2",
                        subBindType: "2",
                        webId: "2"
                    }, {id: "2"});
                    H("wbrebind")
                };
                var D = function (Q) {
                    var R = e.getPosition(Q), O = e.getPosition(K), N = R.left - O.left - 64, P = R.top - O.top - (e.isIE == 7 ? 56 : 58);
                    if (P < 2) {
                        if (e.isIE6) {
                            P = -20
                        } else {
                            P = -16
                        }
                    }
                    if (e.isIE6 && P > 0) {
                        P -= 4
                    }
                    if (!e.g(C)) {
                        F.getService("superpage", "guidetip", function (V) {
                            var U = V.render({
                                id: C,
                                arrowPosLeft: 91,
                                widthoutYahei: true,
                                arrowType: "download",
                                width: 180,
                                pos: {left: N, top: P},
                                hasClose: true,
                                content: '绑定已过期，将无法获取最新消息提醒，点击<a id="s_msgbox_rebind_weibo_tip" href="#" style="color: #0360AF;" onclick="return false;">重新绑定</a>'
                            });
                            e.insertHTML(K, "beforeEnd", U);
                            var W = e.g(C), S = e.q("guide-tip-arrow-download", W)[0];
                            e.setStyle(W, "zIndex", 201);
                            if (e.isIE6) {
                                e.setStyles(S, {bottom: "0px", zoom: 1})
                            }
                            var X = e.q("guide-tip-close", W)[0];
                            e.on(X, "click", function (Y) {
                                H("wbclose");
                                e.stopEvent(Y)
                            });
                            e.on(C, "mouseover", function () {
                                if (!l) {
                                    F.getService("msg", "snsBind", function (Y) {
                                        e.on(C, "click", function () {
                                            G(Y)
                                        })
                                    });
                                    l = true
                                }
                            })
                        })
                    }
                    i.listen("nav/nav", "toggleEditMode", function () {
                        e.g(C) && e.remove(C)
                    });
                    i.listen("nav/nav_direct_change", "changeFinished", function () {
                        e.g(C) && e.remove(C)
                    });
                    setTimeout(function () {
                        i.fire("guidePopupShow", {opType: "wbview"})
                    }, 2000)
                };
                D(E)
            }
        }

        function k(A) {
            T.on(e.g("s_mod_nav"), "mouseover", function (B) {
                if (!t) {
                    F.getService("superpage", "tips", function (C) {
                        try {
                            s.tips = new C.Tips("s_tips");
                            if (!A.bindTip) {
                                v(A)
                            }
                        } catch (D) {
                        }
                    });
                    t = true
                } else {
                    if (s.tips) {
                        if (!A.bindTip) {
                            v(A)
                        }
                    }
                }
            })
        }

        function w(B, C) {
            s.msgBoxesData[C] = p;
            u(B, p.position, p.html);
            if (p.position == "beforeEnd") {
                if (p.html) {
                    e.setAttr(B, "title", "")
                } else {
                    if (p.tipConf && p.tipConf.tipHtml) {
                        e.setAttr(B, "title", "")
                    }
                }
            }
            p.init(B);
            p.inited = true;
            k(p);
            if (B && !e.q("bm-bind", B)[0]) {
                var A = e.q("s-nav-name", B)[0];
                e.setAttr(A, "title", "")
            }
            s.addMsgDone = true;
            i.fire("addMsgDone", {id: C})
        }

        function v(A) {
            e.forEach(A.bindDoms, function (B) {
                s.tips.Add(B, {
                    ShowDelay: 300, Custom: {left: e.isIE ? -2 : 0, top: 27}, onShow: function () {
                        A.showTip()
                    }
                })
            });
            A.bindTip = true
        }

        function u(B, I, H) {
            if (T.dom.hasClass(B, "bm-mark")) {
                e.forEach(e.q("bm-mark", B), function (L) {
                    e.remove(L)
                });
                T.removeClass(B, "bm-mark")
            }
            var A = e.q("s-nav-name", B)[0], D = e.q("sc-dragitem", A)[0], C = 80, J = s_session.userProp.isNplus, K = null, G = null, K = "s_nav_area", G = J ? "nplus-edit" : "nori-edit";
            if (B.id.indexOf("s_nused") >= 0 || B.id.indexOf("s_nadd") >= 0) {
                if (!H) {
                    C = 98
                } else {
                    C = 80
                }
            } else {
                if (T.dom.hasClass && T.dom.hasClass(e.g(K), G)) {
                    if (h.isNplus()) {
                        C = 70
                    } else {
                        C = 80
                    }
                } else {
                    if (!H) {
                        H = "";
                        if (h.isClassify()) {
                            C = 98
                        } else {
                            C = 120
                        }
                    } else {
                        if (h.isClassify()) {
                            C = 80
                        } else {
                            C = 100
                        }
                    }
                }
            }
            g(D, D.innerHTML, C);
            var E = (I == "beforeEnd" ? A : B);
            if (H) {
                e.insertHTML(E, "beforeEnd", H);
                T.addClass(B, "bm-mark")
            }
        }

        function j(A) {
            if (s.tips) {
                s.tips.clearHide = A
            }
        }

        function q(B) {
            var A = s.msgBoxesData[B];
            if (A) {
                return A
            } else {
                return null
            }
        }

        s.init = z;
        s.getMsgBoxDataById = q;
        s.addMsg = m;
        s.setClearHide = j;
        s.bindNavItemHover = k
    });
    f.navMsg = new a()
});
F.module("nav:nav/nav_util", function (b, e, l) {
    var d = l.base;
    var a = b("nav/nav_str_manager");
    var j = a.navNameHandler;
    var c;
    var g;
    var i;
    var h;
    var f = d.Class.create(function () {
        var r = this;
        r.config = {
            commonusedweb: {name: "常用", className: "nused", navData: {}},
            myweb: {name: "全部", className: "nav", navData: {}},
            hotweb: {name: "热门", className: "nori", navData: {}}
        };
        r.getCurTab = function () {
            return s_session.userTips.currentWebTab
        };
        r.getTabName = function (s) {
            return r.config[s || r.getCurTab()].name
        };
        r.getCurClassName = function (s) {
            return r.config[s || r.getCurTab()].className
        };
        r.isTab = function (t) {
            var s = r.getCurTab();
            return s == t
        };
        r.isCommUsedWeb = function () {
            var s = r.getCurTab();
            return s == "commonusedweb"
        };
        r.isMyWeb = function () {
            var s = r.getCurTab();
            return s == "myweb"
        };
        r.isHotWeb = function () {
            var s = r.getCurTab();
            return s == "hotweb"
        };
        r.isNplus = function () {
            return s_session.userProp.isNplus
        };
        r.isClassify = function () {
            return r.isNplus()
        };
        r.setNplus = function (s) {
            s_session.userProp.isNplus = s
        };
        r.setTitle = function (u) {
            var s = r.getCurClassName(), v = u.id.replace("s_" + s + "_", ""), t = d.q("s-nav-name", u)[0];
            o(function () {
                p(function () {
                    var w = i.getNavById(v);
                    msgBox = g.getMsgBoxDataById(v);
                    if (msgBox) {
                        if (msgBox.position == "beforeEnd") {
                            if (!msgBox.html) {
                                if (!(msgBox.tipConf && msgBox.tipConf.tipHtml)) {
                                    d.setAttr(t, "title", w.name)
                                }
                            }
                        } else {
                            T.setAttr(t, "title", w.name)
                        }
                    } else {
                        T.setAttr(t, "title", w.name)
                    }
                })
            })
        };
        r.handleName = function (v) {
            var s = r.getCurClassName(), w = v.id.replace("s_" + s + "_", ""), t = v.getElementsByTagName("em")[0], u = 100;
            m(function () {
                if (c.isEdit()) {
                    if (r.isCommUsedWeb()) {
                        u = 100
                    } else {
                        if (r.isNplus()) {
                            u = d.isIE ? 65 : 67
                        } else {
                            u = 80
                        }
                    }
                } else {
                    p(function () {
                        if (g.getMsgBoxDataById(w)) {
                            if (r.isClassify()) {
                                u = 80
                            } else {
                                u = 100
                            }
                        } else {
                            if (r.isClassify()) {
                                u = 98
                            } else {
                                u = 120
                            }
                        }
                    })
                }
                j(t, t.innerHTML, u)
            })
        };
        r.handleDirName = function (s) {
            if (d.isFirefox < 7) {
                j(s, s.innerHTML, 75)
            }
        };
        var m = function (s) {
            if (c) {
                s && s()
            } else {
                l.use("nav/skeleton", function (t) {
                    c = t.skeleton;
                    s && s()
                })
            }
        };
        var p = function (s) {
            if (g) {
                s && s()
            } else {
                l.use("nav/nav_msg", function (t) {
                    g = t.navMsg;
                    s && s()
                })
            }
        };
        var o = function (s) {
            if (i) {
                s && s()
            } else {
                l.use("nav/nav_data_controller", function (t) {
                    i = t.ndc;
                    s && s()
                })
            }
        };
        r.setClick = function (s) {
            d.on(s, "click", function (t) {
                m(function () {
                    if (c.isEdit()) {
                        d.stopEvent(t)
                    }
                })
            })
        };
        var n = function (s) {
            r.config[r.getCurTab].navData = s
        };
        var q = function () {
            return r.config[r.getCurTab].navData
        };
        r.parseNavData = function (x) {
            var t = x;
            var w = {}, v = [], y = {}, u = {};
            d.forEach(t, function (z) {
                if (z) {
                    v.push(z.dirId);
                    y[z.dirId] = z.dirName;
                    u[z.dirId] = [];
                    w[z.dirId] = {};
                    if (z.navs) {
                        d.forEach(z.navs, function (A) {
                            A.url = decodeURIComponent(A.url);
                            A.dirId = z.dirId;
                            u[z.dirId].push(A.id);
                            w[z.dirId][A.id] = A
                        })
                    }
                }
            });
            var s = {dirNames: y, seqDirs: v, seqNavs: u, navs: w, data: t};
            return s
        };
        r.openAddWin = function (s, t) {
            l.use("nav/open_res", function (u) {
                if (!h) {
                    h = new u.OpenRes()
                }
                h.showLayer(s, t)
            })
        }
    });
    var k = new f();
    e.navUtil = k
});
F.module("nav:nav/nav_str_manager", function (d, c, a) {
    var e = a.base;
    var b = new (d("superpage:common/strpx")).Strpx("font:normal 14px arial,宋体,sans-serif");
    c.navNameHandler = (function () {
        if (e.isFirefox < 7 || e.isChrome) {
            return function (h, g, f) {
                if (e.isChrome) {
                    f = f + 2
                }
                if (g.indexOf("&") > -1) {
                    h.innerHTML = e.encodeHTML(b.substringByPx(e.decodeHTML(g), f, "..."))
                } else {
                    h.innerHTML = b.substringByPx(g, f, "...")
                }
                if (b.getLengthPx(g) > f) {
                    return true
                } else {
                    return false
                }
            }
        } else {
            return function (h, g, f) {
                if (g.indexOf("&") > -1) {
                    g = e.decodeHTML(g)
                }
                if (b.getLengthPx(g) > f) {
                    h.style.width = f + "px";
                    return true
                } else {
                    h.style.width = "auto";
                    return false
                }
            }
        }
    })();
    c.getLengthPx = b.getLengthPx
});
F.module("nav:nav/nav_direct_change", function (f, r, n) {
    var d = n.base;
    var i = new f("superpage:common/tween").Class, a = f("superpage:common/user_attr");
    var o, l, c = false, p = "none", g = "_" + s_session.portrait + "_navUsedExtendConditionNew", b = false;
    var q = "s_ndirect_area", e = "s_nav_area", m = "s_mod_nav_content";
    d.setOpacity = d.setOpacity || function (t, s) {
            if (window.getComputedStyle) {
                t.style.opacity = s
            } else {
                if (document.documentElement.currentStyle) {
                    if (!t.currentStyle.hasLayout) {
                        t.style.zoom = 1
                    }
                    if (!t.currentStyle.hasLayout) {
                        t.style.display = "inline-block"
                    }
                    try {
                        if (t.filters) {
                            if (t.filters("alpha")) {
                                t.filters("alpha").opacity = s * 100
                            } else {
                                t.style.filter += "alpha(opacity=" + s * 100 + ")"
                            }
                        }
                    } catch (u) {
                        t.style.filter = "alpha(opacity=" + s * 100 + ")"
                    }
                }
            }
        };
    r.init = function () {
        if (!c) {
            o = d.g("s_ndirect_change");
            if (o) {
                l = o.getElementsByTagName("a")[0];
                d.on(l, "click", function () {
                    if (b) {
                        return
                    }
                    if (p) {
                        h()
                    }
                    n.fire("btnChangeClick", {toState: p});
                    if (p == true) {
                        n.use("nav/nav_used_extend_tip", function (s) {
                            s.init(r.change)
                        })
                    } else {
                        r.change()
                    }
                })
            }
            j();
            n.listen("nav/nav_addform", "navUsedSwitchTurn", j);
            n.listen("nav/nav_nused", "AllNusedNavDeleted", j);
            c = true
        }
    };
    var j = function () {
        if (s_session.isUsedNav) {
            if (s_session.userTips.isNavUsed) {
                if (d.g("s_nused_area").getElementsByTagName("li")[0]) {
                    if (d.hasClass(d.g("s_ndirect_area"), "unshown")) {
                        p = false
                    } else {
                        p = true
                    }
                } else {
                    p = "none"
                }
            } else {
                p = "none"
            }
        } else {
            p = "none"
        }
    };
    r.change = function (s, v) {
        r.init();
        if (p == "none") {
            v && v();
            return
        }
        if (("all" == s && !p) || ("used" == s && p)) {
            r.setBtnSate();
            v && v()
        } else {
            var u = p ? d.g(q) : d.g(e), t = p ? d.g(e) : d.g(q);
            b = true;
            k(t, u, v)
        }
    };
    var k = function (t, u, v) {
        var s = d.g(u).offsetHeight;
        new i({
            duration: 500, trans: "regularEaseIn", from: 1, to: 0.1, func: function () {
                d.setOpacity(u, this.tween)
            }, ondestroy: function () {
                d.addClass(u, "unshown");
                d.setOpacity(u, 0.1);
                d.removeClass(t, "unshown");
                var w = t.offsetHeight;
                d.setStyles(t, {height: s + "px", overflow: "hidden"});
                d.setOpacity(t, 0.1);
                new i({
                    duration: 500, trans: "regularEaseIn", from: 0.1, to: 1, func: function () {
                        d.setStyle(t, "height", ((this.tween - 0.1) / 0.9 * (w - s) + s) + "px");
                        d.setOpacity(t, this.tween)
                    }, ondestroy: function () {
                        d.setStyles(t, {height: "", overflow: "visible"});
                        d.setOpacity(t, 1);
                        if (p != "none") {
                            p = !p;
                            l.innerHTML = (p ? "展开全部" : "只展现常用") + "<span></span>";
                            o.className = "s-ndirect-change " + (p ? "extend" : "collect")
                        }
                        r.setBtnSate();
                        v && v();
                        j();
                        b = false;
                        n.fire("changeFinished")
                    }
                })
            }
        })
    };
    r.setBtnSate = function () {
        if (!o) {
            return
        }
        if (s_session.isNavInEdit) {
            d.addClass(o, "unshown")
        } else {
            if (s_session.isUsedNav) {
                if (s_session.userTips.isNavUsed) {
                    if (d.g("s_nused_area").getElementsByTagName("li")[0]) {
                        d.removeClass(o, "unshown")
                    } else {
                        d.addClass(o, "unshown")
                    }
                } else {
                    d.addClass(o, "unshown")
                }
            } else {
                d.addClass(o, "unshown")
            }
        }
    };
    r.isMoving = function () {
        return b
    };
    var h = function () {
        F.getService("superpage", "localstorage", function (t) {
            var s = t.ls;
            if (s) {
                var u = new Date(), v = Math.floor(u / 86400000);
                s.get(g, function (z, y) {
                    if (z != 2) {
                        if (y == "donot") {
                            return
                        }
                        if (!y) {
                            y = v + "-1"
                        } else {
                            var x = y.split("#"), A = x[x.length - 1];
                            if (parseInt(v) != parseInt(A.split("-")[0])) {
                                if (x.length >= 3) {
                                    x.splice(0, x.length - 2)
                                }
                                x.push(v + "-1")
                            } else {
                                var w = parseInt(A.split("-")[1]) + 1;
                                x[x.length - 1] = A.split("-")[0] + "-" + w
                            }
                            y = x.join("#")
                        }
                        s.set(g, y)
                    }
                })
            }
        })
    }
});